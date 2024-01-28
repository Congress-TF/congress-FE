package com.example.congress.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.congress.data.model.ActModel
import com.example.congress.databinding.ItemNewsBinding

class ActAdapter : RecyclerView.Adapter<ActAdapter.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener
    private var actList = listOf<ActModel>()

    inner class ViewHolder(val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ActModel) {
            binding.apply {
                tvNewsTitle.text = item.title
                tvNewsPerson.text = item.person
                tvNewsSession.text = item.session
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(actList[position])
    }

    override fun getItemCount(): Int {
        return actList.size
    }

    fun setActList(list: List<ActModel>) {
        actList = list
        notifyDataSetChanged()
    }
}