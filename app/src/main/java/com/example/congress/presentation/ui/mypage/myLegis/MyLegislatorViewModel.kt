package com.example.congress.presentation.ui.mypage.myLegis

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.congress.base.BaseViewModel
import com.example.congress.data.model.MyPageLegislatorResponse
import com.example.congress.domain.usecase.MyPageLegislatorUseCaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyLegislatorViewModel @Inject constructor(
    private val myPageLegislatorUseCaseUseCase: MyPageLegislatorUseCaseUseCase
): BaseViewModel() {
    private val _legislatorLists = MutableLiveData<MyPageLegislatorResponse>()
    val legislatorLists: LiveData<MyPageLegislatorResponse> = _legislatorLists


    fun getlegislatorLists(userId: String) {
        viewModelScope.launch {
            val list = myPageLegislatorUseCaseUseCase(
                userId = userId
            )
            _legislatorLists.value = list
        }
    }
}