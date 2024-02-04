package com.example.congress.presentation.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.congress.data.model.LegislatorModel
import com.example.congress.databinding.ItemActBinding
import com.example.congress.presentation.ui.revision.RevisionActivity

class LegislatorAdapter(
    userId: String
) : RecyclerView.Adapter<LegislatorAdapter.ViewHolder>() {
    private var actList = listOf<LegislatorModel>()
    private var userId = userId

    inner class ViewHolder(val binding: ItemActBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LegislatorModel) {
            binding.apply {
                tvNewsTitle.text = item.name
                tvNewsPerson.text = item.section
                tvNewsSession.text = item.unit

                binding.tvDetail.setOnClickListener { view ->
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
        val view = ItemActBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(actList[position])
    }

    override fun getItemCount(): Int {
        return actList.size
    }

    fun setActList(list: List<LegislatorModel>) {
        actList = list
        notifyDataSetChanged()
    }
}