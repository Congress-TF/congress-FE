package com.example.congress.presentation.ui.like

import androidx.lifecycle.ViewModelProvider
import com.example.congress.R
import com.example.congress.base.BaseFragment
import com.example.congress.data.model.ActModel
import com.example.congress.databinding.FragmentLikeBinding
import com.example.congress.presentation.adapter.ActAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LikeFragment(userId: String) : BaseFragment<FragmentLikeBinding>(R.layout.fragment_like) {
    private lateinit var adapter: ActAdapter
    private lateinit var viewModel: LikeViewModel

    private val likeActList = listOf(
        ActModel(type = "Type", title = "의안명 1", person = "제안자 1", session = "제안회기 1"),
        ActModel(type = "Type", title = "의안명 2", person = "제안자 2", session = "제안회기 2"),
        ActModel(type = "Type", title = "의안명 3", person = "제안자 3", session = "제안회기 3"),
        ActModel(type = "Type", title = "의안명 1", person = "제안자 1", session = "제안회기 1"),
        ActModel(type = "Type", title = "의안명 2", person = "제안자 2", session = "제안회기 2"),
        ActModel(type = "Type", title = "의안명 3", person = "제안자 3", session = "제안회기 3"),
        ActModel(type = "Type", title = "의안명 1", person = "제안자 1", session = "제안회기 1"),
        ActModel(type = "Type", title = "의안명 2", person = "제안자 2", session = "제안회기 2"),
    )

    override fun createView(binding: FragmentLikeBinding) {
        viewModel = ViewModelProvider(this).get(LikeViewModel::class.java)
    }

    override fun viewCreated() {
        setAdapter()
    }

    private fun setAdapter() {
        adapter = ActAdapter()
        binding.rvHome.adapter = adapter

        adapter.setActList(likeActList)
    }
}