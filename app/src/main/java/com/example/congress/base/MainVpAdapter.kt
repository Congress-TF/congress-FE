package com.example.congress.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.congress.mypage.MyPageFragment
import com.example.congress.news.NewsFragment

class MainVpAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    private val fragments = listOf(NewsFragment(),MyPageFragment())
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}