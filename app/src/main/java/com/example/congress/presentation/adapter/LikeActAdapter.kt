package com.example.congress.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.congress.data.model.ActModel
import com.example.congress.data.model.LikeActModel
import com.example.congress.databinding.ItemActBinding

class LikeActAdapter : RecyclerView.Adapter<LikeActAdapter.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener
    private var likeActList = listOf<LikeActModel>()

    inner class ViewHolder(val binding: ItemActBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LikeActModel) {
            binding.apply {
                tvNewsTitle.text = item.title
                tvNewsPerson.text = item.person
                tvNewsSession.text = item.session
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemActBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(likeActList[position])
    }

    override fun getItemCount(): Int {
        return likeActList.size
    }

    fun setActList(list: List<LikeActModel>) {
        likeActList = list
        notifyDataSetChanged()
    }
}