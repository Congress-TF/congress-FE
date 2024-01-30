package com.example.congress.presentation.ui.mypage.info

import android.os.Bundle
import androidx.activity.viewModels
import com.example.congress.R
import com.example.congress.base.BaseActivity
import com.example.congress.data.model.MemberMyInfoResponse
import com.example.congress.data.model.MemberSignInRequest
import com.example.congress.databinding.ActivityMyInfoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyInfoActivity : BaseActivity<ActivityMyInfoBinding>(R.layout.activity_my_info) {
    private val viewModel: MyInfoViewModel by viewModels()
    private var userId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userId = intent.getStringExtra("USER_ID")
        initView()
        moveToBack()
        viewModel.getMemberMyInfo(userId = userId.toString())

        observeViewModel()
    }

    override fun initView() {
        super.initView()
        setupYearPicker()

        binding.tvComplete.setOnClickListener {
            val nickname = viewModel.nickname.toString()
            val gender = viewModel.gender.value.toString()
            val age = viewModel.age.value.toString()

            val memberUpdateRequest = MemberSignInRequest(nickname, gender, age, userId.toString())

            viewModel.putMemberUpdate(memberUpdateRequest)
        }
    }


    private fun observeViewModel() {
        viewModel.memberMyInfo.observe(this) { myInfo ->
            myInfo?.let {
                displayMyInfo(it)
            }
        }
    }

    private fun displayMyInfo(myInfo: MemberMyInfoResponse) {
        binding.tvNickname.setText(myInfo.payload?.nickname ?: "")
        // 성별 설정
        if (myInfo.payload?.gender == "남자") {
            binding.radioMan.isChecked = true
        } else {
            binding.radioWoman.isChecked = true
        }
        // 연도 설정
        binding.yearPicker.value = myInfo.payload?.year?.toInt() ?: 2024
    }

    private fun moveToBack() {
        binding.ivBack.setOnClickListener {
            finish()
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