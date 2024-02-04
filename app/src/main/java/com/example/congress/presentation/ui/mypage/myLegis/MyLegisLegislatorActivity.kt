package com.example.congress.presentation.ui.mypage.myLegis

import android.os.Bundle
import androidx.activity.viewModels
import com.example.congress.R
import com.example.congress.base.BaseActivity
import com.example.congress.data.model.MyLegislatorModel
import com.example.congress.databinding.ActivityMyLegisBinding
import com.example.congress.presentation.adapter.MyLegislatorAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyLegisLegislatorActivity : BaseActivity<ActivityMyLegisBinding>(R.layout.activity_my_legis) {
    private val viewModel: MyLegislatorViewModel by viewModels()
    private lateinit var adapter: MyLegislatorAdapter
    private var userId: String? = null

    private val myLegislatorList: MutableList<MyLegislatorModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userId = intent.getStringExtra("USER_ID")
        viewModel.getlegislatorLists(userId = userId.toString())
        observeLegislatorLists()

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

    private fun observeLegislatorLists() {
        viewModel.legislatorLists.observe(this) { legislatorLists ->
            if (legislatorLists.payload.isNullOrEmpty()) {
                binding.tvSorting.text = "아직 의정활동 참여도에 투표 하지 않았어요"
            } else {
                myLegislatorList.clear()
                legislatorLists.payload.forEach { lawItem ->
                    val legislatorModel = MyLegislatorModel(
                        name = lawItem.legislatorName,
                        score = lawItem.score,
                    )
                    myLegislatorList.add(legislatorModel)
                }
                adapter.setActList(myLegislatorList)
            }
        }
    }

    private fun setAdapter() {
        adapter = MyLegislatorAdapter(userId = userId.toString())

        binding.rvHome.adapter = adapter

        adapter.setActList(myLegislatorList)
    }
}