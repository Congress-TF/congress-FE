package com.example.congress.presentation.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.congress.R
import com.example.congress.base.BaseViewModel
import com.example.congress.data.model.MemberSignInRequest
import com.example.congress.domain.usecase.MemberSignInUseCase
import com.example.congress.domain.usecase.TestUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val memberSignInUseCase: MemberSignInUseCase,
    private val testUseCase: TestUseCase
) : BaseViewModel() {

    private val _loginUiState: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState.None)
    val loginUiState: StateFlow<LoginUiState>
        get() = _loginUiState

    private val _nickname = MutableStateFlow("")
    val nickname: StateFlow<String> = _nickname.asStateFlow()

    private val _gender = MutableStateFlow("")
    val gender: StateFlow<String> = _gender.asStateFlow()

    private val _age = MutableStateFlow("")
    val age: StateFlow<String> = _age.asStateFlow()

    val _isVisible = MutableLiveData<Boolean>()
    val isVisible: LiveData<Boolean> = _isVisible

    fun test() {
        viewModelScope.launch {
            testUseCase.invoke()
        }
    }

    fun login() {
        _loginUiState.update { LoginUiState.Loding }

        viewModelScope.launch {

        }
    }

    fun postMemberSignIn(memberSignInRequest: MemberSignInRequest) {
        viewModelScope.launch {
            memberSignInUseCase.invoke(memberSignInRequest)

        }
    }
}

sealed interface LoginUiState {
    object None: LoginUiState
    object Loding: LoginUiState
    data class Success(val initMemberModel: MemberSignInRequest )
}