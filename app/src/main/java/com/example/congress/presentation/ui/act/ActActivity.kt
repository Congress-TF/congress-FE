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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActActivity : BaseActivity<ActivityActBinding>(R.layout.activity_act) {
    private val viewModel: ActViewModel by viewModels()
    private var userId: String? = null
    private var lawName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()

        observeHashtagRank()
        observeVoteTotal()
        observeLawDetail()
        observeLawVote()

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

        viewModel.getLawDetail(userId = userId.toString(), lawName = lawName.toString())
        viewModel.getHashtagRank(lawName = lawName.toString())
        viewModel.getVoteTotal(lawName = lawName.toString())
        viewModel.getLawVote(userId = userId.toString(), lawName = lawName.toString())

        hashtagTextWatcher()
        moveToBack()
        initLink()

        postVote(userId.toString(), lawName.toString())
        postHashtag(userId.toString(), lawName.toString())
    }

    private fun observeHashtagRank() {
        viewModel.hashtagRank.observe(this) { response ->
            response?.let { hashtagRankResponse ->
                if (hashtagRankResponse.payload.isNullOrEmpty()) {
                    showEmptyHashtagsMessage()
                } else {
                    displayHashtags(hashtagRankResponse.payload)
                }
            }
        }
    }


    private fun observeVoteTotal() {
        viewModel.voteTotal.observe(this) { response ->
            response?.let {
                binding.tvScore.text = response.payload.toString()
            }
        }
    }

    private fun observeLawDetail() {
        viewModel.lawDetail.observe(this) { response ->
            response?.let {
                binding.tvBillNo.text = response.payload?.billNo.toString()
                binding.tvLawTitle.text = response.payload?.billNm.toString()
                binding.tvPerson.text = response.payload?.proposer.toString()
                binding.tvDt.text = response.payload?.proposerDt.toString()
            }
        }
    }

    private fun observeLawVote() {
        viewModel.lawVote.observe(this) { response ->
            response?.let {
                val yesCountString = response.payload?.yesCount
                val voteCount =
                    yesCountString?.toIntOrNull() ?: 0 // 기본값을 0으로 설정하거나 다른 기본값으로 설정할 수 있습니다.
                binding.tvVote.text = "${voteCount}표"

                val maxProgress = 76
                val progress = if (voteCount >= maxProgress) {
                    maxProgress
                } else {
                    voteCount
                }
                binding.progress.progress = progress
            }
        }
    }


    private fun showEmptyHashtagsMessage() {
        val emptyHashtagsMessage = "아직 해시태그가 없어요"
        binding.textView9.text = emptyHashtagsMessage
        val parentLayout = binding.clComment
        parentLayout.removeAllViews()
    }

    private fun displayHashtags(hashtags: List<HashtagRankPayload>) {
        val hashtagViews = listOf(binding.tvFirst, binding.tvSecond, binding.tvThird)

        for (i in 0 until 3) {
            if (i < hashtags.size) {
                hashtagViews[i].apply {
                    visibility = View.VISIBLE
                    text = "#${hashtags[i].tag}"
                }
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
                        Toast.makeText(this, "개정 필요도에 투표했어요", Toast.LENGTH_SHORT).show()
                    },
                    onError = {
                        Toast.makeText(this, "투표에 실패했어요", Toast.LENGTH_SHORT).show()
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
                        Toast.makeText(this, "의견을 남겼어요", Toast.LENGTH_SHORT).show()
                    },
                    onError = {
                        Toast.makeText(this, "의견을 남기는데 실패했어요", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }



}
