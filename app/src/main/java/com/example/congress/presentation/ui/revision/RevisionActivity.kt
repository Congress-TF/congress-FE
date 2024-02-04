package com.example.congress.presentation.ui.revision

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.congress.R
import com.example.congress.base.BaseActivity
import com.example.congress.data.model.VoteRequest
import com.example.congress.databinding.ActivityRevisionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RevisionActivity : BaseActivity<ActivityRevisionBinding>(R.layout.activity_revision) {

    private val viewModel : RevisionViewModel by viewModels()
    private var userId: String? = null
    private var legislatorName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeLegislatorDetail()
        viewModel.voteTotal.observe(this) { response ->
            response?.let {
                binding.tvScore.text = response.payload.toString()
            }
        }

        initView()
    }

    override fun initView() {
        super.initView()
        userId = intent.getStringExtra("USER_ID")
        legislatorName = intent.getStringExtra("LEGISLATOR_NAME")
        viewModel.getLegislatorMemberDetail(userId = userId.toString(), legislatorName = legislatorName.toString())
        viewModel.getVoteLegislatorTotal(legislatorName = legislatorName.toString())

        postVote(userId.toString(), legislatorName.toString())

        moveToBack()
    }

    private fun observeLegislatorDetail() {
        viewModel.lawLegislator.observe(this) { response ->
            response?.let {
                binding.tvHgNm.text = response.payload?.hgNm.toString()
                binding.tvBth.text = response.payload?.bthDate.toString()
                binding.tvGender.text = response.payload?.sexGbnNm.toString()
                binding.tvReele.text = response.payload?.reeleGbnNm.toString()
                binding.tvUnits.text = response.payload?.units.toString()
                binding.tvUnitNm.text = response.payload?.unitNm.toString()
                binding.tvPoly.text = response.payload?.polyNm.toString()
                binding.tvOrig.text = response.payload?.origNm.toString()
                binding.tvDateOne.text = response.payload?.ftToDateOne.toString()
                binding.tvSjOne.text = response.payload?.profileSjOne.toString()
                binding.tvDateTwo.text = response.payload?.frToDateTwo.toString()
                binding.tvSjTwo.text = response.payload?.profileSjTwo.toString()
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
            val voteRequest = VoteRequest(userId, legislatorName, rating)

            if (rating != 0) {
                viewModel.postVote(
                    voteRequest,
                    onSuccess = {
                        viewModel.getVoteLegislatorTotal(legislatorName)
                        Toast.makeText(this, "의정활동 참여도에 투표했어요", Toast.LENGTH_SHORT).show()
                    },
                    onError = {
                        Toast.makeText(this, "투표에 실패했어요", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }
}