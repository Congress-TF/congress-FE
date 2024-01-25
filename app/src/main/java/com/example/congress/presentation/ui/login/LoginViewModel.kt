package com.example.congress.presentation.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.congress.data.model.MemberSignInRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
) : ViewModel() {

    private val _loginUiState: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState.None)
    val loginUiState: StateFlow<LoginUiState>
        get() = _loginUiState

    fun login() {
        _loginUiState.update { LoginUiState.Loding }

        viewModelScope.launch {

        }
    }
}

sealed interface LoginUiState {
    object None: LoginUiState
    object Loding: LoginUiState
    data class Success(val initMemberModel: MemberSignInRequest )
}