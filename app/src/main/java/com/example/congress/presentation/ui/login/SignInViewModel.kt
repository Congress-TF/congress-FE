package com.example.congress.presentation.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.congress.base.BaseViewModel
import com.example.congress.data.model.MemberSignInRequest
import com.example.congress.domain.usecase.MemberSignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val memberSignInUseCase: MemberSignInUseCase,
) : BaseViewModel() {
    private val _nickname = MutableLiveData<String>()
    val nickname: LiveData<String> = _nickname

    private val _gender = MutableLiveData<String>()
    val gender: LiveData<String> = _gender

    private val _age = MutableLiveData<String>()
    val age: LiveData<String> = _age

    // 닉네임 설정 메서드
    fun setNickname(nickname: String) {
        _nickname.value = nickname
    }

    // 성별 설정 메서드
    fun setGender(gender: String) {
        _gender.value = gender
    }

    // 나이 설정 메서드
    fun setAge(age: String) {
        _age.value = age
    }

    // 회원 가입 요청 전송 메서드
    fun postMemberSignIn(memberSignInRequest: MemberSignInRequest) {
        viewModelScope.launch {
            memberSignInUseCase.invoke(memberSignInRequest)
        }
    }
}