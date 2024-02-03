package com.example.congress.presentation.ui.like

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.congress.base.BaseViewModel
import com.example.congress.data.model.CongressMembersResponse
import com.example.congress.domain.usecase.LawLegislatorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LikeViewModel @Inject constructor(
    private val lawLegislatorUseCase: LawLegislatorUseCase
) : BaseViewModel() {
    private val _legislatorList = MutableLiveData<CongressMembersResponse>()
    val legislatorList: LiveData<CongressMembersResponse> = _legislatorList

    fun getLegislatorList() {
        viewModelScope.launch {
            val legislator = lawLegislatorUseCase()
            _legislatorList.value = legislator
        }
    }

}