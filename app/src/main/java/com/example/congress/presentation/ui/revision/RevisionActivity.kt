package com.example.congress.presentation.ui.revision

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.congress.R
import com.example.congress.base.BaseActivity
import com.example.congress.data.model.VoteLegislatorRequest
import com.example.congress.databinding.ActivityRevisionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RevisionActivity : BaseActivity<ActivityRevisionBinding>(R.layout.activity_revision) {

    private val viewModel : RevisionViewModel by viewModels()
    private var userId: String? = null
    private var legislatorName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fetchData()
        initView()
    }

    override fun initView() {
        super.initView()
        userId = intent.getStringExtra("USER_ID")
        legislatorName = intent.getStringExtra("LEGISLATOR_NAME")

        postVote(userId.toString(), legislatorName.toString())

        moveToBack()
    }


    private fun fetchData() {
        showLoadingAnimation()
        hideOtherViews()

        viewModel.getLegislatorMemberDetail(userId = userId.toString(), legislatorName = legislatorName.toString())
        viewModel.getVoteLegislatorTotal(legislatorName = legislatorName.toString())

        observeData()
    }

    private fun observeData() {
        viewModel.voteTotal.observe(this) { response ->
            response?.let {
                binding.tvScore.text = response.payload.toString()
                hideLoadingIfDataReceived()
            }
        }

        viewModel.lawLegislator.observe(this) { response ->
            response?.let {
                val payload = response.payload ?: return@let // payload가 null이면 함수 종료

                binding.tvHgNm.text = if (payload.hgNm.isNullOrEmpty()) "데이터가 없어요" else payload.hgNm
                binding.tvBth.text = if (payload.bthDate.isNullOrEmpty()) "데이터가 없어요" else payload.bthDate
                binding.tvGender.text = if (payload.sexGbnNm.isNullOrEmpty()) "데이터가 없어요" else payload.sexGbnNm
                binding.tvReele.text = if (payload.reeleGbnNm.isNullOrEmpty()) "데이터가 없어요" else payload.reeleGbnNm
                binding.tvUnits.text = if (payload.units.isNullOrEmpty()) "데이터가 없어요" else payload.units
                binding.tvUnitNm.text = if (payload.unitNm.isNullOrEmpty()) "데이터가 없어요" else payload.unitNm
                binding.tvPoly.text = if (payload.polyNm.isNullOrEmpty()) "데이터가 없어요" else payload.polyNm
                binding.tvOrig.text = if (payload.origNm.isNullOrEmpty()) "데이터가 없어요" else payload.origNm
                binding.tvDateOne.text = if (payload.ftToDateOne.isNullOrEmpty()) "데이터가 없어요" else payload.ftToDateOne
                binding.tvSjOne.text = if (payload.profileSjOne.isNullOrEmpty()) "데이터가 없어요" else payload.profileSjOne
                binding.tvDateTwo.text = if (payload.frToDateTwo.isNullOrEmpty()) "데이터가 없어요" else payload.frToDateTwo
                binding.tvSjTwo.text = if (payload.profileSjTwo.isNullOrEmpty()) "데이터가 없어요" else payload.profileSjTwo

                hideLoadingIfDataReceived()
            }
        }
    }


    private fun moveToBack() {
        binding.ivBack.setOnClickListener {
            finish()
        }
    }


    private fun postVote(
        userId: String,
        legislatorName: String,
    ) {
        binding.tvSendRat.setOnClickListener {
            val rating = binding.ratingBar.rating.toInt()
            val voteRequest = VoteLegislatorRequest(userId, legislatorName, rating)

            if (rating != 0) {
                viewModel.postVote(
                    voteRequest,
                    onSuccess = {
                        viewModel.getVoteLegislatorTotal(legislatorName)
                        Toast.makeText(this, "의정활동 참여도에 투표했어요", Toast.LENGTH_SHORT).show()
                    },
                    onError = {
                        Toast.makeText(this, "이미 투표한 국회의원이에요", Toast.LENGTH_SHORT).show()
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

    private fun hideLoadingIfDataReceived() {
        if (viewModel.voteTotal.value != null && viewModel.lawLegislator.value != null) {
            hideLoadingAnimation()
            showOtherViews()
        }
    }
}