package com.example.congress.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.congress.R
import com.example.congress.databinding.ItemCategoryDetailBinding

class CategoryDetailAdapter() : RecyclerView.Adapter<CategoryDetailAdapter.ViewHolder>() {
    private var selectedPosition = 0
    private var categoryList = listOf("교통", "경제", "고용", "환경", "문화")

    inner class ViewHolder(val binding: ItemCategoryDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var isSelected = false
        var actCategoryDetail = binding.btnCategoryDetail


        fun bind(item: String) {
            binding.apply {
                btnCategoryDetail.text = item
            }
        }

        init {
            binding.btnCategoryDetail.setOnClickListener { view ->
                val clickedPosition = adapterPosition
                if (selectedPosition != clickedPosition) {
                    isSelected = true
                    notifyItemChanged(selectedPosition)
                    selectedPosition = clickedPosition
                }
                updateButtonStyles()
            }
        }

        fun updateButtonStyles() {
            if (isSelected) {
                actCategoryDetail.setTextColor(ContextCompat.getColor(itemView.context, R.color.white))
                actCategoryDetail.setBackgroundResource(R.drawable.bg_act)
            } else {
                actCategoryDetail.setTextColor(ContextCompat.getColor(itemView.context, R.color.gray_7))
                actCategoryDetail.setBackgroundResource(R.drawable.bg_act_disable)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemCategoryDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categoryList[position])
        holder.isSelected = selectedPosition == position
        holder.updateButtonStyles()
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}