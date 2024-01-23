package com.example.congress.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.congress.R
import com.example.congress.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!
    private var adapter = NewsListAdapter()
    private var sampleList = mutableListOf<NewsData>(NewsData(1, mainText = "안녕하세요sdasdasfddfsshsdfgsfdhhdsfhfs", subText = "안녕"),NewsData(1, mainText = "안녕하세요", subText = "안녕"),NewsData(1, mainText = "안녕하세요", subText = "안녕"),NewsData(1, mainText = "안녕하세요4", subText = "안녕4"))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSearchView()
        setNewsList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initSearchView(){
        binding.svNewsSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
//                adapter.clearItem()
//                settest(query.toString())

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    private fun setNewsList(){
        adapter.addAll(sampleList)
        binding.rvNewsList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvNewsList.adapter = adapter

    }


}