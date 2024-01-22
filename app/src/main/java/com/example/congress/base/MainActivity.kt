package com.example.congress.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.congress.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val vpAdapter = MainVpAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()

    }

    private fun initView() {
        val tabsName = listOf("News", "MyPage", "TimeLine","Rank","MyPage")
        binding.vpMain.adapter = vpAdapter
        binding.vpMain.isUserInputEnabled = false
        TabLayoutMediator(binding.tabLayout, binding.vpMain) { tab, position ->
            tab.text = tabsName[position]
        }.attach()
    }
}