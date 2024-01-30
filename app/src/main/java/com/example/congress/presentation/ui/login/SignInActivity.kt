package com.example.congress.presentation.ui.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import com.example.congress.R
import com.example.congress.base.BaseActivity
import com.example.congress.data.model.MemberSignInRequest
import com.example.congress.databinding.ActivitySignUpBinding
import com.example.congress.presentation.ui.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
    private val viewModel: SignInViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        selectRadioButton()
    }

    override fun initView() {
        super.initView()
        val userId = intent.getStringExtra("USER_ID")

        binding.root.setOnClickListener {
            hideKeyboard()
        }

        nickTextWatcher()
        setupYearPicker()

        binding.tvComplete.setOnClickListener {
            val nickname = viewModel.nickname.value.toString()
            val gender = viewModel.gender.value.toString()
            val age = viewModel.age.value.toString()

            val memberSignInRequest = MemberSignInRequest(nickname, gender, age, userId.toString())

            viewModel.postMemberSignIn(memberSignInRequest)
            moveHomeActivity()
        }

        viewModel.nickname.observe(this) {
            updateCompleteButtonState()
        }

        viewModel.gender.observe(this) {
            updateCompleteButtonState()
        }

        viewModel.age.observe(this) {
            updateCompleteButtonState()
        }

    }


    private fun hideKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        currentFocus?.clearFocus()
    }


    private fun nickTextWatcher() {
        binding.tvNickname.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {
                // 텍스트가 변경될 때마다 뷰모델에 값을 설정합니다.
                viewModel.setNickname(p0.toString())
            }
        })
    }


    private fun updateCompleteButtonState() {
        val nickFlag = viewModel.nickname.value
        val genderFlag = viewModel.gender.value
        val ageFlag = viewModel.age.value

        // null 체크와 값이 비어 있는지 확인
        if (!nickFlag.isNullOrEmpty() && !genderFlag.isNullOrEmpty() && !ageFlag.isNullOrEmpty()) {
            with(binding.tvComplete) {
                setBackgroundResource(R.drawable.bg_abled_btn)
                isEnabled = true
            }
        } else {
            with(binding.tvComplete) {
                setBackgroundResource(R.drawable.bg_disabled_btn)
                isEnabled = false
            }
        }
    }

    private fun moveHomeActivity() {
        run {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }

    private fun selectRadioButton() {
        val radioGroup = binding.radioGroup

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radio_man -> {
                    viewModel.setGender("남자")
                }
                R.id.radio_woman -> {
                    viewModel.setGender("여자")
                }
            }
        }
    }


    private fun setupYearPicker() {
        val yearPicker = binding.yearpickerDatepicker
        val currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR)

        yearPicker.minValue = 1900
        yearPicker.maxValue = currentYear
        yearPicker.value = currentYear

        yearPicker.setOnValueChangedListener { picker, oldVal, newVal ->
            viewModel.setAge(newVal.toString())
        }
    }
}
