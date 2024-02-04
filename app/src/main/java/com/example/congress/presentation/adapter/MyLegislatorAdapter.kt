package com.example.congress.presentation.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.congress.data.model.MyLegislatorModel
import com.example.congress.databinding.ItemMyLegisBinding
import com.example.congress.presentation.ui.revision.RevisionActivity

class MyLegislatorAdapter(
    userId: String,
) : RecyclerView.Adapter<MyLegislatorAdapter.ViewHolder>() {
    private var myLegislatorList = listOf<MyLegislatorModel>()
    private var userId = userId


    inner class ViewHolder(val binding: ItemMyLegisBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MyLegislatorModel) {
            binding.apply {
                tvNewsTitle.text = item.name
                tvScore.text = "${item.score.toString()}"

                tvDetail.setOnClickListener { view ->
                    val intent = Intent(view.context, RevisionActivity::class.java).apply {
                        putExtra("USER_ID", userId)
                        putExtra("LEGISLATOR_NAME", item.name)
                    }
                    view.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemMyLegisBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(myLegislatorList[position])
    }

    override fun getItemCount(): Int {
        return myLegislatorList.size
    }

    fun setActList(list: List<MyLegislatorModel>) {
        myLegislatorList = list
        notifyDataSetChanged()
    }
}