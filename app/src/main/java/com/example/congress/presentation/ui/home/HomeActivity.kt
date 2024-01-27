package com.example.congress.presentation.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.congress.R
import com.example.congress.base.BaseActivity
import com.example.congress.databinding.ActivityHomeBinding
import com.example.congress.presentation.ui.act.ActFragment
import com.example.congress.presentation.ui.mypage.MyPageFragment
import com.example.congress.presentation.ui.revision.RevisionFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {
    // 프래그먼트 매니저
    private val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initView() {
        super.initView()

        initFragment()
        initBottomNavigation()
    }

    // 바텀 네비게이션으로 프래그먼트 간 화면 전환
    private fun initBottomNavigation() {

        binding.btmNavViewHome.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.nav_fragment_home -> {
                    HomeFragment().changeFragment()
                }
                R.id.nav_fragment_act -> {
                    ActFragment().changeFragment()
                }
                R.id.nav_fragment_revision -> {
                    RevisionFragment().changeFragment()
                }
                R.id.nav_fragment_my_page -> {
                    MyPageFragment().changeFragment()
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    // 프래그먼트 전환 작업
    private fun Fragment.changeFragment() {
        manager.beginTransaction().replace(R.id.fv_home, this).commit()
    }

    // 초기 프래그먼트 선언
    private fun initFragment() {
        val transaction = manager.beginTransaction()
            .add(R.id.fv_home, HomeFragment())
        transaction.commit()
    }


}