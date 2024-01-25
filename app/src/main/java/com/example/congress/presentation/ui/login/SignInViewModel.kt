package com.example.congress.presentation.ui.login

import androidx.lifecycle.viewModelScope
import com.example.congress.base.BaseViewModel
import com.example.congress.data.model.MemberSignInRequest
import com.example.congress.domain.usecase.MemberSignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val memberSignInUseCase: MemberSignInUseCase
) : BaseViewModel() {

    private val _loginUiState: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState.None)
    val loginUiState: StateFlow<LoginUiState>
        get() = _loginUiState

    fun login() {
        _loginUiState.update { LoginUiState.Loding }

        viewModelScope.launch {

        }
    }

    fun postMemberSignIn(memberSignInRequest: MemberSignInRequest) {
        viewModelScope.launch {
            // MemberSignInUseCase를 통해 서버에 회원가입 요청 전송
            memberSignInUseCase.invoke(memberSignInRequest)
        }
    }
}

sealed interface LoginUiState {
    object None: LoginUiState
    object Loding: LoginUiState
    data class Success(val initMemberModel: MemberSignInRequest )
}