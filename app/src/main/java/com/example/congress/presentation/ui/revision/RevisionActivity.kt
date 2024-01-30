package com.example.congress.presentation.ui.revision

import android.os.Bundle
import com.example.congress.R
import com.example.congress.base.BaseActivity
import com.example.congress.databinding.ActivityRevisionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RevisionActivity : BaseActivity<ActivityRevisionBinding>(R.layout.activity_revision) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
        super.initView()
        moveToBack()
    }

    private fun moveToBack() {
        binding.ivBack.setOnClickListener {
            finish()
        }
    }
}