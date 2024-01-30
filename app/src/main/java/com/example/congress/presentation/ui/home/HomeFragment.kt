package com.example.congress.presentation.ui.home

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.congress.R
import com.example.congress.base.BaseFragment
import com.example.congress.data.model.ActModel
import com.example.congress.databinding.FragmentHomeBinding
import com.example.congress.presentation.adapter.ActAdapter
import com.example.congress.presentation.adapter.CategoryAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var actAdapter: ActAdapter

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
        categoryAdapter = CategoryAdapter()
        actAdapter = ActAdapter()

        binding.rvActCategory.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvActCategory.adapter = categoryAdapter
        binding.rvHome.adapter = actAdapter

         actAdapter.setActList(actList)
    }
}