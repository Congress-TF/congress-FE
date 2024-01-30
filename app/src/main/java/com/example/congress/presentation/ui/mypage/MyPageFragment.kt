package com.example.congress.presentation.ui.mypage

import android.content.Intent
import com.example.congress.R
import com.example.congress.base.BaseFragment
import com.example.congress.databinding.FragmentMyPageBinding
import com.example.congress.presentation.ui.mypage.info.MyInfoActivity
import com.example.congress.presentation.ui.mypage.myAct.MyActActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPageFragment : BaseFragment<FragmentMyPageBinding>(R.layout.fragment_my_page) {

    override fun createView(binding: FragmentMyPageBinding) {
        binding.tvMyInfo.setOnClickListener {
            moveToMyInfo()
        }
        binding.tvMyAct.setOnClickListener {
            moveToMyAct()
        }
    }

    override fun viewCreated() {
    }


    private fun moveToMyInfo() {
        activity?.let {
            val intent = Intent(it, MyInfoActivity::class.java)
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