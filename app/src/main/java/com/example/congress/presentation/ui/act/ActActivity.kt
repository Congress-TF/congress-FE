package com.example.congress.presentation.ui.act

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.congress.R
import com.example.congress.base.BaseActivity
import com.example.congress.data.model.HashtagRankPayload
import com.example.congress.data.model.HashtagSaveRequest
import com.example.congress.data.model.VoteRequest
import com.example.congress.databinding.ActivityActBinding
import com.example.congress.presentation.ui.home.HomeViewModel
import com.example.congress.presentation.ui.mypage.myAct.MyActViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActActivity : BaseActivity<ActivityActBinding>(R.layout.activity_act) {
    private val viewModel: ActViewModel by viewModels()
    private val homeViewModel: HomeViewModel by viewModels()
    private val myActViewModel: MyActViewModel by viewModels()


    private var userId: String? = null
    private var lawName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fetchData()
        initView()


        viewModel.voteTotal.observe(this) { response ->
            response?.let {
                binding.tvScore.text = response.payload.toString()
            }
        }

        viewModel.hashtagRank.observe(this) { response ->
            response?.let {
                if (it.payload.isNullOrEmpty()) {
                    showEmptyHashtagsMessage()
                } else {
                    displayHashtags(it.payload)
                }
            }
        }
    }

    override fun initView() {
        super.initView()


        userId = intent.getStringExtra("USER_ID")
        lawName = intent.getStringExtra("LAW_NAME")

        hashtagTextWatcher()
        moveToBack()
        initLink()

        postVote(userId.toString(), lawName.toString())
        postHashtag(userId.toString(), lawName.toString())
    }

    private fun fetchData() {
        showLoadingAnimation()
        hideOtherViews()

        viewModel.getLawDetail(userId = userId.toString(), lawName = lawName.toString())
        viewModel.getHashtagRank(lawName = lawName.toString())
        viewModel.getVoteTotal(lawName = lawName.toString())
        viewModel.getLawVote(userId = userId.toString(), lawName = lawName.toString())

        observeData()
    }


    private fun observeData() {
        viewModel.voteTotal.observe(this) { response ->
            response?.let {
                binding.tvScore.text = response.payload.toString()
                hideLoadingIfDataReceived()
            }
        }

        viewModel.hashtagRank.observe(this) { response ->
            response?.let {
                if (it.payload.isNullOrEmpty()) {
                    showEmptyHashtagsMessage()
                } else {
                    displayHashtags(it.payload)
                }
                hideLoadingIfDataReceived()
            }
        }

        viewModel.lawDetail.observe(this) { response ->
            response?.let {
                binding.tvBillNo.text = response.payload?.billNo.toString()
                binding.tvLawTitle.text = response.payload?.billNm.toString()
                binding.tvPerson.text = response.payload?.proposer.toString()
                binding.tvDt.text = response.payload?.proposerDt.toString()
                hideLoadingIfDataReceived()
            }
        }

        viewModel.lawVote.observe(this) { response ->
            response?.let {
                val yesCountString = response.payload?.yesCount
                val voteCount = yesCountString?.toIntOrNull() ?: 0
                binding.tvVote.text = "${voteCount}표"
                val maxProgress = 76
                val progress = if (voteCount >= maxProgress) maxProgress else voteCount
                binding.progress.progress = progress
                hideLoadingIfDataReceived()
            }
        }
    }


    private fun hideLoadingIfDataReceived() {
        if (viewModel.voteTotal.value != null &&
            viewModel.hashtagRank.value != null &&
            viewModel.lawDetail.value != null &&
            viewModel.lawVote.value != null
        ) {
            hideLoadingAnimation()
            showOtherViews()
        }
    }

    private fun showEmptyHashtagsMessage() {
        val emptyHashtagsMessage = "아직 해시태그가 없어요"
        binding.textView9.text = emptyHashtagsMessage
        val parentLayout = binding.clComment
        parentLayout.removeAllViews()
    }

    private fun displayHashtags(hashtags: List<HashtagRankPayload>) {
        val parentLayout = binding.clComment
        parentLayout.removeAllViews()

        binding.textView9.text = "많이 언급된 키워드"

        val hashtagViews = listOf(binding.tvFirst, binding.tvSecond, binding.tvThird)

        for (i in 0 until 3) {
            if (i < hashtags.size) {
                hashtagViews[i].apply {
                    visibility = View.VISIBLE
                    text = "#${hashtags[i].tag}"
                }
                parentLayout.addView(hashtagViews[i])
            } else {
                hashtagViews[i].visibility = View.GONE
            }
        }
    }

    private fun moveToBack() {
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun initLink() {
        binding.btnLink.setOnClickListener {
            val detailLink = viewModel.lawDetail.value?.payload?.detailLink
            if (!detailLink.isNullOrEmpty()) {
                openWebPage(detailLink)
            }
        }
    }

    private fun openWebPage(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    private fun hashtagTextWatcher() {
        binding.edtHashtag.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {
                viewModel.setHashtag(p0.toString())
            }
        })
    }

    private fun postVote(
        userId: String,
        lawName: String,
    ) {
        binding.tvSendRat.setOnClickListener {
            val rating = binding.ratingBar.rating.toInt()
            val voteRequest = VoteRequest(userId, lawName, rating)

            if (rating != 0) {
                viewModel.postVote(
                    voteRequest,
                    onSuccess = {
                        viewModel.getVoteTotal(lawName)
                        homeViewModel.updateLawLists()
                        myActViewModel.updateLawLists(userId)
                        Toast.makeText(this, "개정 필요도에 투표했어요", Toast.LENGTH_SHORT).show()
                    },
                    onError = {
                        Toast.makeText(this, "이미 투표에 참여했어요", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }

    private fun postHashtag(
        userId: String,
        lawName: String,
    ) {
        binding.tvSend.setOnClickListener {
            val hashtag = viewModel.hashtag.value.toString()

            val hashtagSaveRequest = HashtagSaveRequest(userId, lawName, hashtag)

            if (hashtag.isNotEmpty()) {
                viewModel.postHashtagSave(
                    hashtagSaveRequest,
                    onSuccess = {
                        viewModel.getHashtagRank(lawName)
                        binding.edtHashtag.setText("")
                        homeViewModel.updateLawLists()
                        myActViewModel.updateLawLists(userId)
                        Toast.makeText(this, "의견을 남겼어요", Toast.LENGTH_SHORT).show()
                    },
                    onError = {
                        Toast.makeText(this, "이미 의견을 남겼어요", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }
    private fun hideOtherViews() {
        binding.clToolbar.visibility = View.GONE
        binding.nestedScrollView.visibility = View.GONE
    }

    private fun showOtherViews() {
        binding.clToolbar.visibility = View.VISIBLE
        binding.nestedScrollView.visibility = View.VISIBLE
    }

    private fun showLoadingAnimation() {
        binding.lottieLoading.visibility = View.VISIBLE
    }

    private fun hideLoadingAnimation() {
        binding.lottieLoading.visibility = View.GONE
    }
}
