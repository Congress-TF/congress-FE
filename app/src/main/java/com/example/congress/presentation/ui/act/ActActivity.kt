package com.example.congress.presentation.ui.act

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.congress.R
import com.example.congress.base.BaseActivity
import com.example.congress.data.model.HashtagRankPayload
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
    }

    override fun initView() {
        super.initView()
        moveToBack()
        userId = intent.getStringExtra("USER_ID")
        lawName = intent.getStringExtra("LAW_NAME")
        viewModel.getHashtagRank(name = "예시 의안")
        viewModel.getLawDetail(userId = userId.toString(), lawName = lawName.toString())
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
}
