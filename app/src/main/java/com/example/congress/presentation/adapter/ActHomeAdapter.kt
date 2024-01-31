package com.example.congress.presentation.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.congress.data.model.ActHomeModel
import com.example.congress.databinding.ItemActHomeBinding
import com.example.congress.presentation.ui.act.ActActivity

class ActHomeAdapter : RecyclerView.Adapter<ActHomeAdapter.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener
    private var actList = listOf<ActHomeModel>()

    inner class ViewHolder(val binding: ItemActHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ActHomeModel) {
            binding.apply {
                tvNewsTitle.text = item.title
                tvNewsPerson.text = item.person
                tvNewsSession.text = item.session
                tvStar.text = item.star
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
        val view = ItemActHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(actList[position])
    }

    override fun getItemCount(): Int {
        return actList.size
    }

    fun setActList(list: List<ActHomeModel>) {
        actList = list
        notifyDataSetChanged()
    }
}