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
    private val memberUpdateUseCase: MemberUpdateUseCase
) : BaseViewModel() {

    private val _memberMyInfo = MutableLiveData<MemberMyInfoResponse>()
    val memberMyInfo: LiveData<MemberMyInfoResponse> = _memberMyInfo

    private val _nickname = MutableLiveData<String>()
    val nickname: LiveData<String> = _nickname

    private val _gender = MutableLiveData<String>()
    val gender: LiveData<String> = _gender

    private val _age = MutableLiveData<String>()
    val age: LiveData<String> = _age


    fun getMemberMyInfo(userId: String) {
        viewModelScope.launch {
            val myInfo = memberMyInfoUseCase(userId)
            _memberMyInfo.value = myInfo
        }
    }

    fun putMemberUpdate(memberUpdateRequest: MemberSignInRequest) {
        viewModelScope.launch {
            memberUpdateUseCase.invoke(memberUpdateRequest)

        }
    }
}