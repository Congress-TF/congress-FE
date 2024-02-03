package com.example.congress.presentation.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.congress.data.model.LegislatorModel
import com.example.congress.databinding.ItemActBinding
import com.example.congress.presentation.ui.revision.RevisionActivity

class LegislatorAdapter : RecyclerView.Adapter<LegislatorAdapter.ViewHolder>() {
    private var actList = listOf<LegislatorModel>()

    inner class ViewHolder(val binding: ItemActBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LegislatorModel) {
            binding.apply {
                tvNewsPerson.text = item.person
                tvNewsSession.text = item.session
            }
        }

        init {
            binding.tvDetail.setOnClickListener { view ->
                val intent = Intent(view.context, RevisionActivity::class.java)
                view.context.startActivity(intent)
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