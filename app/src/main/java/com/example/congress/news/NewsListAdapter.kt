package com.example.congress.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.congress.base.ViewType
import com.example.congress.databinding.ItemNewsListBinding
import com.example.congress.news.holder.NewsListHolder

class NewsListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items = mutableListOf<NewsData>()

    fun addAll(item: MutableList<NewsData>) {
        items.addAll(0, item)
        notifyItemRangeInserted(0, itemCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ViewType.NEWS_VIEW -> NewsListHolder(
                ItemNewsListBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )

            else -> NewsListHolder(
                ItemNewsListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is NewsListHolder -> holder.bind(items[position])
        }
    }
}