package com.example.congress.presentation.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.congress.presentation.adapter.MainVpAdapter
import com.example.congress.presentation.ui.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val mainVM by viewModels<LoginViewModel>()


    private val vpAdapter = MainVpAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}