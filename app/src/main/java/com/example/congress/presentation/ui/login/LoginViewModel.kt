package com.example.congress.presentation.ui.login

import androidx.lifecycle.viewModelScope
import com.example.congress.base.BaseViewModel
import com.example.congress.domain.usecase.MemberCheckUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val memberCheckUseCase: MemberCheckUseCase,
) : BaseViewModel() {


    fun getMemberCheck(userId: String) {
        viewModelScope.launch {
            memberCheckUseCase.invoke(userId = userId)
        }
    }
}
