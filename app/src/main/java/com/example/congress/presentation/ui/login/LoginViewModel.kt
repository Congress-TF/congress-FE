package com.example.congress.presentation.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val _isMember = MutableLiveData<Boolean>()
    val isMember: LiveData<Boolean> = _isMember

    fun getMemberCheck(userId: String) {
        viewModelScope.launch {
            val isMemberResult = memberCheckUseCase.invoke(userId = userId).payload!!
            _isMember.postValue(isMemberResult)
        }
    }
}
