package com.example.congress.presentation.ui.like

import com.example.congress.R
import com.example.congress.base.BaseFragment
import com.example.congress.data.model.LikeActModel
import com.example.congress.databinding.FragmentLikeBinding
import com.example.congress.presentation.adapter.LikeActAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LikeFragment : BaseFragment<FragmentLikeBinding>(R.layout.fragment_like) {
    private lateinit var adapter: LikeActAdapter
    private val likeActList = listOf(
        LikeActModel(type = "Type", title = "의안명 1", person = "제안자 1", session = "제안회기 1"),
        LikeActModel(type = "Type", title = "의안명 2", person = "제안자 2", session = "제안회기 2"),
        LikeActModel(type = "Type", title = "의안명 3", person = "제안자 3", session = "제안회기 3"),
        LikeActModel(type = "Type", title = "의안명 1", person = "제안자 1", session = "제안회기 1"),
        LikeActModel(type = "Type", title = "의안명 2", person = "제안자 2", session = "제안회기 2"),
    )

    override fun createView(binding: FragmentLikeBinding) {

    }

    override fun viewCreated() {
        setAdapter()
    }

    private fun setAdapter(){
        adapter = LikeActAdapter()

        binding.rvHome.adapter = adapter

        adapter.setActList(likeActList)
    }
}