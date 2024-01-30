package com.example.congress.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.congress.R
import com.example.congress.databinding.ItemCategoryBinding

class CategoryAdapter(private val onCategorySelected: (String) -> Unit) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    private var selectedPosition = 0
    private var actList = listOf("법률", "개정 법률")

    inner class ViewHolder(val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var isSelected = false
        var actCategory = binding.btnAct


        fun bind(item: String) {
            binding.apply {
                btnAct.text = item
            }
        }

        init {
            binding.btnAct.setOnClickListener { view ->
                val actCategory = actCategory.text.toString()

                val clickedPosition = adapterPosition
                if (selectedPosition != clickedPosition) {
                    isSelected = true
                    notifyItemChanged(selectedPosition)
                    selectedPosition = clickedPosition
                }
                updateButtonStyles()
                onCategorySelected(actCategory)
            }
        }

        fun updateButtonStyles() {
            if (isSelected) {
                actCategory.setTextColor(ContextCompat.getColor(itemView.context, R.color.black))
                actCategory.setBackgroundResource(R.drawable.bg_abled_btn)
            } else {
                actCategory.setTextColor(ContextCompat.getColor(itemView.context, R.color.gray_7))
                actCategory.setBackgroundResource(R.drawable.bg_disabled_btn)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(actList[position])
        holder.isSelected = selectedPosition == position
        holder.updateButtonStyles()
    }

    override fun getItemCount(): Int {
        return actList.size
    }
}