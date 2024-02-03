package com.example.congress.presentation.ui.home

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.congress.R
import com.example.congress.base.BaseFragment
import com.example.congress.data.model.ActHomeModel
import com.example.congress.databinding.FragmentHomeBinding
import com.example.congress.presentation.adapter.ActHomeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment(userId: String) : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private lateinit var actHomeAdapter: ActHomeAdapter
    private lateinit var viewModel: HomeViewModel

    private val actList: MutableList<ActHomeModel> = mutableListOf()

    override fun createView(binding: FragmentHomeBinding) {
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun viewCreated() {
        setAdapter()
        observeLawLists()
    }

    private fun observeLawLists() {
        viewModel.lawLists.observe(viewLifecycleOwner) { lawLists ->
            actList.clear()
            lawLists.payload?.forEach { lawItem ->
                val actModel = ActHomeModel(
                    type = "Act",
                    title = lawItem.billNm,
                    person = lawItem.proposer,
                    session = lawItem.proposerDt,
                    star = lawItem.score.toString()
                )
                actList.add(actModel)
            }
            actHomeAdapter.setActList(actList)
        }
        viewModel.getLawLists()
    }

    private fun setAdapter() {
        actHomeAdapter = ActHomeAdapter()
        binding.rvHome.layoutManager = LinearLayoutManager(requireContext())
        binding.rvHome.adapter = actHomeAdapter
    }
}
