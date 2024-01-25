package com.example.congress.presentation.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import com.example.congress.R
import com.example.congress.databinding.ActivityMainBinding
import com.example.congress.base.BaseActivity
import com.example.congress.presentation.ui.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    val mainVM by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initView() {
        super.initView()
    }
}