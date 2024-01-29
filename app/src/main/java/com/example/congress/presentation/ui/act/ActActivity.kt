package com.example.congress.presentation.ui.act

import android.os.Bundle
import com.example.congress.R
import com.example.congress.base.BaseActivity
import com.example.congress.databinding.ActivityActBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActActivity : BaseActivity<ActivityActBinding>(R.layout.activity_act) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
        super.initView()
    }
}