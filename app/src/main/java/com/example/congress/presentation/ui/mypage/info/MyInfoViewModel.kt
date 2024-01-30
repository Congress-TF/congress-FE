package com.example.congress.presentation.ui.mypage.info

import androidx.lifecycle.viewModelScope
import com.example.congress.base.BaseViewModel
import com.example.congress.domain.usecase.MemberMyInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyInfoViewModel @Inject constructor(
    private val memberMyInfoUseCase: MemberMyInfoUseCase
) : BaseViewModel() {
    fun getMemberMyInfo(userId: String) {
        viewModelScope.launch {
            memberMyInfoUseCase(userId)
        }
    }
}