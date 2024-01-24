package com.example.congress.presentation.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import com.example.congress.R
import com.example.congress.databinding.ActivityMainBinding
import com.example.congress.presentation.adapter.MainVpAdapter
import com.example.congress.presentation.base.BaseActivity
import com.example.congress.presentation.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    val mainVM by viewModels<LoginViewModel>()


    private val vpAdapter = MainVpAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setupInit() {

    }

    override fun subscribeUi() {
        super.subscribeUi()
    }
}