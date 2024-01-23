package com.example.congress.news.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.congress.databinding.ItemNewsListBinding
import com.example.congress.news.NewsData

class NewsListHolder(private val binding: ItemNewsListBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: NewsData) {
        binding.tvNewsTitle.text = item.mainText
        binding.tvNewsInfo.text = item.subText
    }
}