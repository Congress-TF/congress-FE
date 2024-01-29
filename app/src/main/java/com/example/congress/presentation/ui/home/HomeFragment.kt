package com.example.congress.presentation.ui.home

import com.example.congress.R
import com.example.congress.base.BaseFragment
import com.example.congress.data.model.ActModel
import com.example.congress.databinding.FragmentHomeBinding
import com.example.congress.presentation.adapter.ActAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private lateinit var adapter: ActAdapter
    private val actList = listOf(
        ActModel(type = "Type", title = "의안명 1", person = "제안자 1", session = "제안회기 1"),
        ActModel(type = "Type", title = "의안명 2", person = "제안자 2", session = "제안회기 2"),
        ActModel(type = "Type", title = "의안명 3", person = "제안자 3", session = "제안회기 3"),
        ActModel(type = "Type", title = "의안명 1", person = "제안자 1", session = "제안회기 1"),
        ActModel(type = "Type", title = "의안명 2", person = "제안자 2", session = "제안회기 2"),
        ActModel(type = "Type", title = "의안명 3", person = "제안자 3", session = "제안회기 3"),
        ActModel(type = "Type", title = "의안명 1", person = "제안자 1", session = "제안회기 1"),
        ActModel(type = "Type", title = "의안명 2", person = "제안자 2", session = "제안회기 2"),
        ActModel(type = "Type", title = "의안명 3", person = "제안자 3", session = "제안회기 3"),
        ActModel(type = "Type", title = "의안명 1", person = "제안자 1", session = "제안회기 1"),
        ActModel(type = "Type", title = "의안명 2", person = "제안자 2", session = "제안회기 2"),
        ActModel(type = "Type", title = "의안명 3", person = "제안자 3", session = "제안회기 3")
    )
    override fun createView(binding: FragmentHomeBinding) {

    }

    override fun viewCreated() {
        setAdapter()
    }

    private fun setAdapter(){
        adapter = ActAdapter()

        binding.rvHome.adapter = adapter

        adapter.setActList(actList)
    }


}