package com.example.congress.presentation.ui.home

import android.view.View
import android.widget.PopupMenu
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.congress.R
import com.example.congress.base.BaseFragment
import com.example.congress.data.model.ActHomeModel
import com.example.congress.databinding.FragmentHomeBinding
import com.example.congress.presentation.adapter.ActHomeAdapter
import com.example.congress.presentation.adapter.CategoryAdapter
import com.example.congress.presentation.adapter.CategoryDetailAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment(userId: String) : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var categoryDetailAdapter: CategoryDetailAdapter
    private lateinit var actHomeAdapter: ActHomeAdapter
    private lateinit var viewModel: HomeViewModel
    private var pageInit: Int = 0
    private var sort = ""

    private val actList = listOf(
        ActHomeModel(type = "Type", title = "의안명 1", person = "제안자 1", session = "제안회기 1", star = "147"),
        ActHomeModel(type = "Type", title = "의안명 1", person = "제안자 1", session = "제안회기 1", star = "147"),
        ActHomeModel(type = "Type", title = "의안명 1", person = "제안자 1", session = "제안회기 1", star = "147"),
        ActHomeModel(type = "Type", title = "의안명 1", person = "제안자 1", session = "제안회기 1", star = "147"),
        ActHomeModel(type = "Type", title = "의안명 1", person = "제안자 1", session = "제안회기 1", star = "147"),
        ActHomeModel(type = "Type", title = "의안명 1", person = "제안자 1", session = "제안회기 1", star = "147"),
        ActHomeModel(type = "Type", title = "의안명 1", person = "제안자 1", session = "제안회기 1", star = "147"),
        ActHomeModel(type = "Type", title = "의안명 1", person = "제안자 1", session = "제안회기 1", star = "147"),
        ActHomeModel(type = "Type", title = "의안명 1", person = "제안자 1", session = "제안회기 1", star = "147"),
        ActHomeModel(type = "Type", title = "의안명 1", person = "제안자 1", session = "제안회기 1", star = "147"),
    )

    override fun createView(binding: FragmentHomeBinding) {
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun viewCreated() {
        setAdapter()

        binding.ibtnSortingMenu.setOnClickListener {
            showSortingMenu(it)
        }

        observeSelectedCategory()
    }

    private fun observeSelectedCategory() {
        viewModel.selectedCategory.observe(viewLifecycleOwner) { category ->
            binding.tvActList.text = "$category 법률 목록"
        }
    }


    private fun setAdapter(){
        categoryAdapter = CategoryAdapter { selectedCategory ->
            viewModel.setSelectedCategory(selectedCategory)
        }
        categoryDetailAdapter = CategoryDetailAdapter()
        actHomeAdapter = ActHomeAdapter()

        binding.rvActCategory.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvActCategory.adapter = categoryAdapter
        binding.rvActCategoryDetail.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvActCategoryDetail.adapter = categoryDetailAdapter
        binding.rvHome.adapter = actHomeAdapter

        actHomeAdapter.setActList(actList)
    }

    private fun showSortingMenu(view: View) {
        val popupMenu = PopupMenu(requireContext(), view)
        popupMenu.menuInflater.inflate(R.menu.menu_sort, popupMenu.menu)

        // 메뉴 아이템 클릭 처리
        popupMenu.setOnMenuItemClickListener { item ->
            pageInit = 0
            when (item.itemId) {
                R.id.menu_sort_like -> {
                    sort = "like"
                    binding.tvSorting.text = "개정 필요도 순"
                }

                R.id.menu_sort -> {
                    sort = "asc"
                    binding.tvSorting.text = "가나다 순"
                }
            }
            true
        }
        popupMenu.show()
    }
}