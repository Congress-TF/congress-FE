package com.example.congress.presentation.ui.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.example.congress.R
import com.example.congress.base.BaseActivity
import com.example.congress.data.model.MemberSignInRequest
import com.example.congress.databinding.ActivitySignUpBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine

@AndroidEntryPoint
class SignInActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {

    private val viewModel: SignInViewModel by viewModels()

    private var nickFlag = false
    private var genderFlag = false
    private var birthFlag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initView() {
        super.initView()

        binding.root.setOnClickListener{
            hideKeyboard()
        }

        nickTextWatcher()

        viewModel.test()

        binding.tvComplete.setOnClickListener {
            val nickname = binding.tvNickname.text.toString()
            val gender = binding.etGender.text.toString()
            val age = binding.etAge.text.toString()
            val email = binding.etEmail.text.toString()

            val memberSignInRequest = MemberSignInRequest(nickname, gender, age, email)

            viewModel.postMemberSignIn(memberSignInRequest)
        }
    }


    private fun hideKeyboard(){
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        currentFocus?.clearFocus()
    }


    private fun nickTextWatcher(){
        val nickname = binding.tvNickname
        binding.tvNickname.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    private fun isComplete(){
        if(nickFlag && genderFlag && birthFlag){
            with(binding.tvComplete){
                setBackgroundResource(R.drawable.bg_abled_btn)
                isEnabled = true
            }
        }else{
            with(binding.tvComplete){
                setBackgroundResource(R.drawable.bg_disabled_btn)
                isEnabled = false
            }
        }
    }
}
