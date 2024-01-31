package com.example.congress.presentation.ui.mypage

import androidx.lifecycle.viewModelScope
import com.example.congress.base.BaseViewModel
import com.example.congress.domain.usecase.MemberSignOutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val memberSignOutUseCase: MemberSignOutUseCase,
) : BaseViewModel() {

    fun deleteMemberSignOut(userId: String) {
        viewModelScope.launch {
            memberSignOutUseCase(userId)
        }
    }
}