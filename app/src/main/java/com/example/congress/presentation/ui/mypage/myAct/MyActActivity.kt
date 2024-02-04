package com.example.congress.presentation.ui.mypage.myAct

import android.os.Bundle
import androidx.activity.viewModels
import com.example.congress.R
import com.example.congress.base.BaseActivity
import com.example.congress.data.model.MyActModel
import com.example.congress.databinding.ActivityMyActBinding
import com.example.congress.presentation.adapter.MyActAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyActActivity : BaseActivity<ActivityMyActBinding>(R.layout.activity_my_act) {
    private val viewModel: MyActViewModel by viewModels()
    private lateinit var adapter: MyActAdapter
    private var userId: String? = null

    private val myActList: MutableList<MyActModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userId = intent.getStringExtra("USER_ID")
        initView()
        observeLawLists()
        moveToBack()
    }

    override fun initView() {
        super.initView()
        setAdapter()
        viewModel.getActLists(userId = userId.toString())
    }

    private fun moveToBack() {
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun observeLawLists() {
        viewModel.actLists.observe(this) { lawLists ->
            if (lawLists.payload.isNullOrEmpty()) {
                binding.tvSorting.text = "아직 개정 필요도에 투표하지 않았어요"
            } else {
                myActList.clear()
                lawLists.payload.forEach { lawItem ->
                    val actModel = MyActModel(
                        title = lawItem.lawName,
                        hashtag = lawItem.hashtag,
                        score = lawItem.score,
                        totalScore = lawItem.totalScore
                    )
                    myActList.add(actModel)
                }
                adapter.setActList(myActList)
            }
        }
    }

    private fun setAdapter() {
        adapter = MyActAdapter(userId = userId.toString())
        binding.rvHome.adapter = adapter
    }
}
