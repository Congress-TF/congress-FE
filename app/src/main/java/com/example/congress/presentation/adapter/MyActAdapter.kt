package com.example.congress.presentation.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.congress.data.model.MyActModel
import com.example.congress.databinding.ItemMyActBinding
import com.example.congress.presentation.ui.act.ActActivity

class MyActAdapter(
    userId: String,
) : RecyclerView.Adapter<MyActAdapter.ViewHolder>() {
    private var myActList = listOf<MyActModel>()
    private var userId = userId


    inner class ViewHolder(val binding: ItemMyActBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MyActModel) {
            binding.apply {
                tvNewsTitle.text = item.title
                tvStar.text = item.totalScore.toString()
                tvHashtag.text = "#${item.hashtag}"
                tvScore.text = "${item.score.toString()}"

                tvDetail.setOnClickListener { view ->
                    val intent = Intent(view.context, ActActivity::class.java).apply {
                        putExtra("USER_ID", userId)
                        putExtra("LAW_NAME", item.title)
                    }
                    view.context.startActivity(intent)
                }
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