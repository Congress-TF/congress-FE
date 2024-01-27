package com.example.congress.presentation.ui.login

import android.os.Bundle
import androidx.activity.viewModels
import com.example.congress.R
import com.example.congress.base.BaseActivity
import com.example.congress.data.model.MemberSignInRequest
import com.example.congress.databinding.ActivitySignUpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInActivity: BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {

    private val viewModel: SignInViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initView() {
        super.initView()

        viewModel.test()

        binding.tvComplete.setOnClickListener {
            val nickname = binding.tvNickname.text.toString()
            val sex = binding.etSex.text.toString()
            val age = binding.etAge.text.toString()
            val email = binding.etEmail.text.toString()

            val memberSignInRequest = MemberSignInRequest(nickname, sex, age, email)

            viewModel.postMemberSignIn(memberSignInRequest)
        }
    }
}