package com.example.congress.presentation.ui.like

import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.congress.R
import com.example.congress.base.BaseFragment
import com.example.congress.data.model.LegislatorModel
import com.example.congress.databinding.FragmentLikeBinding
import com.example.congress.presentation.adapter.LegislatorAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LikeFragment(userId: String) : BaseFragment<FragmentLikeBinding>(R.layout.fragment_like) {
    private lateinit var adapter: LegislatorAdapter
    private lateinit var viewModel: LikeViewModel
    private val userId = userId

    private val legislatorList: MutableList<LegislatorModel> = mutableListOf()

    override fun createView(binding: FragmentLikeBinding) {
        viewModel = ViewModelProvider(this).get(LikeViewModel::class.java)
    }

    override fun viewCreated() {
        setAdapter()
        observeLegislatorLists()
    }


    private fun observeLegislatorLists() {
        viewModel.legislatorList.observe(viewLifecycleOwner) { lawLists ->
            if (lawLists.payload.isNullOrEmpty()) {
                showLoadingAnimation()
            } else {
                hideLoadingAnimation()
                legislatorList.clear()
                lawLists.payload?.forEach { lawItem ->
                    val legislator = LegislatorModel(
                        name = lawItem.name,
                        section = lawItem.section,
                        unit = lawItem.unit
                    )
                    legislatorList.add(legislator)
                }
                adapter.setActList(legislatorList)
            }
        }
        viewModel.getLegislatorList()
    }


    private fun setAdapter() {
        adapter = LegislatorAdapter(userId = userId)
        binding.rvHome.adapter = adapter

        adapter.setActList(legislatorList)
    }

    private fun showLoadingAnimation() {
        binding.lottieLoading.visibility = View.VISIBLE
    }

    private fun hideLoadingAnimation() {
        binding.lottieLoading.visibility = View.GONE
    }
}