package com.example.congress.presentation.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.congress.databinding.ItemNewsListBinding
import com.example.congress.data.model.NewsModel

class NewsListHolder(private val binding: ItemNewsListBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: NewsModel) {
        binding.tvNewsTitle.text = item.mainText
        binding.tvNewsInfo.text = item.subText
    }
}