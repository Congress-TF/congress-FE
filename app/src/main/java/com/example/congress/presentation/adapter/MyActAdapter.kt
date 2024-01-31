package com.example.congress.presentation.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.congress.data.model.MyActModel
import com.example.congress.databinding.ItemMyActBinding
import com.example.congress.presentation.ui.act.ActActivity

class MyActAdapter : RecyclerView.Adapter<MyActAdapter.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener
    private var myActList = listOf<MyActModel>()

    inner class ViewHolder(val binding: ItemMyActBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MyActModel) {
            binding.apply {
                tvNewsTitle.text = item.title
                tvNewsPerson.text = item.person
                tvNewsSession.text = item.session
            }
        }
        init {
            binding.tvDetail.setOnClickListener { view ->
                val intent = Intent(view.context, ActActivity::class.java)
                view.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemMyActBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(myActList[position])
    }

    override fun getItemCount(): Int {
        return myActList.size
    }

    fun setActList(list: List<MyActModel>) {
        myActList = list
        notifyDataSetChanged()
    }
}