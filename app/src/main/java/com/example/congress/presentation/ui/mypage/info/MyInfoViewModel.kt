package com.example.congress.presentation.ui.mypage.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.congress.base.BaseViewModel
import com.example.congress.data.model.MemberMyInfoResponse
import com.example.congress.domain.usecase.MemberMyInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyInfoViewModel @Inject constructor(
    private val memberMyInfoUseCase: MemberMyInfoUseCase
) : BaseViewModel() {

    private val _memberMyInfo = MutableLiveData<MemberMyInfoResponse>()
    val memberMyInfo: LiveData<MemberMyInfoResponse> = _memberMyInfo


    fun getMemberMyInfo(userId: String) {
        viewModelScope.launch {
            val myInfo = memberMyInfoUseCase(userId)
            _memberMyInfo.value = myInfo
        }
    }
}