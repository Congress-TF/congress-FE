package com.example.congress.presentation.ui.mypage.info

import android.os.Bundle
import android.widget.Toast
import com.example.congress.R
import com.example.congress.base.BaseActivity
import com.example.congress.databinding.ActivityMyInfoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyInfoActivity : BaseActivity<ActivityMyInfoBinding>(R.layout.activity_my_info) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        moveToBack()
    }

    override fun initView() {
        super.initView()
        selectRadioButton()
        setupYearPicker()
    }

    private fun moveToBack() {
        binding.ivBack.setOnClickListener {
            finish()
        }
    }
    private fun selectRadioButton() {
        val radioGroup = binding.radioGroup

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radio_man -> {
                    Toast.makeText(this, "남자", Toast.LENGTH_SHORT).show()
                }
                R.id.radio_woman -> {
                    Toast.makeText(this, "여자", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    private fun setupYearPicker() {
        val yearPicker = binding.yearPicker
        val currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR)

        yearPicker.minValue = 1900
        yearPicker.maxValue = currentYear
        yearPicker.value = currentYear

    }


}