package com.example.congress.presentation.ui.mypage

import android.content.Intent
import com.example.congress.R
import com.example.congress.base.BaseFragment
import com.example.congress.databinding.FragmentMyPageBinding
import com.example.congress.presentation.ui.mypage.info.MyInfoActivity
import com.example.congress.presentation.ui.mypage.myAct.MyActActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPageFragment(private var userId: String) : BaseFragment<FragmentMyPageBinding>(R.layout.fragment_my_page) {

    override fun createView(binding: FragmentMyPageBinding) {

    }

    override fun viewCreated() {
        binding.tvMyInfo.setOnClickListener {
            moveToMyInfo(userId = userId)
        }
        binding.tvMyAct.setOnClickListener {
            moveToMyAct()
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
            val intent = Intent(it, MyActActivity::class.java)
            it.startActivity(intent)
        }
    }
}