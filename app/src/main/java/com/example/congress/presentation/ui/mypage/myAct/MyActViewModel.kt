package com.example.congress.presentation.ui.mypage.myAct

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.congress.base.BaseViewModel
import com.example.congress.data.model.MyPageVoteResponse
import com.example.congress.domain.usecase.MyPageActUseCaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyActViewModel @Inject constructor(
    private val myPageActUseCaseUseCase: MyPageActUseCaseUseCase
): BaseViewModel() {
    private val _actLists = MutableLiveData<MyPageVoteResponse>()
    val actLists: LiveData<MyPageVoteResponse> = _actLists


    fun getActLists(userId: String) {
        viewModelScope.launch {
            val actList = myPageActUseCaseUseCase(
                userId = userId
            )
            _actLists.value = actList
        }
    }
}