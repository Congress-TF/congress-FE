package com.example.congress.presentation.ui.mypage.myAct

import android.os.Bundle
import com.example.congress.R
import com.example.congress.base.BaseActivity
import com.example.congress.data.model.MyActModel
import com.example.congress.databinding.ActivityMyActBinding
import com.example.congress.presentation.adapter.MyActAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyActActivity : BaseActivity<ActivityMyActBinding>(R.layout.activity_my_act) {

    private lateinit var adapter: MyActAdapter

    private val myActList = listOf(
        MyActModel(type = "Type", title = "의안명 1", person = "제안자 1", session = "제안회기 1"),
        MyActModel(type = "Type", title = "의안명 2", person = "제안자 2", session = "제안회기 2"),
        MyActModel(type = "Type", title = "의안명 3", person = "제안자 3", session = "제안회기 3"),
        MyActModel(type = "Type", title = "의안명 1", person = "제안자 1", session = "제안회기 1"),
        MyActModel(type = "Type", title = "의안명 2", person = "제안자 2", session = "제안회기 2"),
        MyActModel(type = "Type", title = "의안명 2", person = "제안자 2", session = "제안회기 2"),
        MyActModel(type = "Type", title = "의안명 3", person = "제안자 3", session = "제안회기 3"),
        MyActModel(type = "Type", title = "의안명 1", person = "제안자 1", session = "제안회기 1"),
        MyActModel(type = "Type", title = "의안명 2", person = "제안자 2", session = "제안회기 2"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        moveToBack()
    }

    override fun initView() {
        super.initView()
        setAdapter()
    }

    private fun moveToBack() {
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun setAdapter() {
        adapter = MyActAdapter()

        binding.rvHome.adapter = adapter

        adapter.setActList(myActList)
    }



}