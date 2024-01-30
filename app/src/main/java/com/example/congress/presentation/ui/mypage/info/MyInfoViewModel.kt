package com.example.congress.presentation.ui.mypage.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.congress.base.BaseViewModel
import com.example.congress.data.model.MemberMyInfoResponse
import com.example.congress.data.model.MemberSignInRequest
import com.example.congress.domain.usecase.MemberMyInfoUseCase
import com.example.congress.domain.usecase.MemberUpdateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyInfoViewModel @Inject constructor(
    private val memberMyInfoUseCase: MemberMyInfoUseCase,
    private val memberUpdateUseCase: MemberUpdateUseCase,
) : BaseViewModel() {

    private val _memberMyInfo = MutableLiveData<MemberMyInfoResponse>()
    val memberMyInfo: LiveData<MemberMyInfoResponse> = _memberMyInfo

    private val _nickname = MutableLiveData<String>()
    val nickname: LiveData<String> = _nickname

    private val _gender = MutableLiveData<String>()
    val gender: LiveData<String> = _gender

    private val _age = MutableLiveData<String>()
    val age: LiveData<String> = _age

    private var originalAge: String? = null

    private fun setOriginalAge(age: String?) {
        originalAge = age
    }

    fun setNickname(nickname: String) {
        _nickname.value = nickname
    }

    fun setGender(gender: String) {
        _gender.value = gender
    }

    fun setAge(age: String) {
        _age.value = age
    }


    fun getMemberMyInfo(userId: String) {
        viewModelScope.launch {
            val myInfo = memberMyInfoUseCase(userId)
            _memberMyInfo.value = myInfo

            setOriginalAge(
                myInfo.payload?.year
            )
        }
    }

    fun putMemberUpdate(memberUpdateRequest: MemberSignInRequest) {
        val currentAge = _age.value

        val finalRequest = MemberSignInRequest(
            _nickname.value.toString(),
            _gender.value.toString(),
            currentAge ?: originalAge.toString(),
            memberUpdateRequest.userId
        )
        viewModelScope.launch {
            memberUpdateUseCase.invoke(finalRequest)
        }
    }
}