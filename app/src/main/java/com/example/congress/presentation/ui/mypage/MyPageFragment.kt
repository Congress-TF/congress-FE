package com.example.congress.presentation.ui.mypage

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import com.example.congress.R
import com.example.congress.base.BaseFragment
import com.example.congress.databinding.FragmentMyPageBinding
import com.example.congress.presentation.ui.mypage.info.MyInfoActivity
import com.example.congress.presentation.ui.mypage.myAct.MyActActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPageFragment(private var userId: String) :
    BaseFragment<FragmentMyPageBinding>(R.layout.fragment_my_page) {

    private lateinit var viewModel: MyPageViewModel

    override fun createView(binding: FragmentMyPageBinding) {
        viewModel = ViewModelProvider(this)[MyPageViewModel::class.java]
    }

    override fun viewCreated() {
        binding.tvMyInfo.setOnClickListener {
            moveToMyInfo(userId = userId)
        }
        binding.tvMyAct.setOnClickListener {
            moveToMyAct()
        }
        binding.tvSignOut.setOnClickListener {
            viewModel.deleteMemberSignOut(userId)
        }
    }


    private fun moveToMyInfo(userId: String) {
        activity?.let {
            val intent = Intent(it, MyInfoActivity::class.java).apply {
                putExtra("USER_ID", userId)
            }
            it.startActivity(intent)
        }
    }

    private fun moveToMyAct() {
        activity?.let {
            val intent = Intent(it, MyActActivity::class.java).apply {
                putExtra("USER_ID", userId)
            }
            it.startActivity(intent)
        }
    }
}