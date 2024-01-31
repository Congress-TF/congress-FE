package com.example.congress.presentation.ui.mypage.myAct

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import com.example.congress.R
import com.example.congress.base.BaseActivity
import com.example.congress.data.model.MyActModel
import com.example.congress.databinding.ActivityMyActBinding
import com.example.congress.presentation.adapter.MyActAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyActActivity : BaseActivity<ActivityMyActBinding>(R.layout.activity_my_act), PopupMenu.OnMenuItemClickListener {

    private lateinit var adapter: MyActAdapter

    private val myActList = listOf(
        MyActModel(type = "Type", title = "의안명 1", person = "제안자 1", session = "제안회기 1"),
        MyActModel(type = "Type", title = "의안명 2", person = "제안자 2", session = "제안회기 2"),
        MyActModel(type = "Type", title = "의안명 3", person = "제안자 3", session = "제안회기 3"),
        MyActModel(type = "Type", title = "의안명 1", person = "제안자 1", session = "제안회기 1"),
        MyActModel(type = "Type", title = "의안명 2", person = "제안자 2", session = "제안회기 2"),
        MyActModel(type = "Type", title = "의안명 2", person = "제안자 2", session = "제안회기 2"),
        MyActModel(type = "Type", title = "의안명 3", person = "제안자 3", session = "제안회기 3"),
        MyActModel(type = "Type", title = "의안명 1", person = "제안자 1", session = "제안회기 1"),
        MyActModel(type = "Type", title = "의안명 2", person = "제안자 2", session = "제안회기 2"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        moveToBack()
    }

    override fun initView() {
        super.initView()
        setAdapter()
        binding.ibSort.setOnClickListener {
            showPopup(binding.ibSort)
        }
    }

    private fun moveToBack() {
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun setAdapter() {
        adapter = MyActAdapter()

        binding.rvHome.adapter = adapter

        adapter.setActList(myActList)
    }


    //    팝업 메뉴 보여주는 커스텀 메소드
    private fun showPopup(v: View) {
        val popup = PopupMenu(this, v) // PopupMenu 객체 선언
        popup.menuInflater.inflate(R.menu.menu_sort, popup.menu) // 메뉴 레이아웃 inflate
        popup.setOnMenuItemClickListener(this) // 메뉴 아이템 클릭 리스너 달아주기
        popup.show() // 팝업 보여주기
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_sort_like -> {
                binding.tvSorting.text = "개정 필요도 순"
            }
            R.id.menu_sort -> {
                binding.tvSorting.text = "가나다 순"
            }
        }
        return true
    }

}