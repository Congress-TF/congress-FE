package com.example.congress.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.congress.base.BaseViewModel
import com.example.congress.data.model.LawListsResponse
import com.example.congress.domain.usecase.LawListsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val lawListsUseCase: LawListsUseCase
) : BaseViewModel() {

    private val _lawLists = MutableLiveData<LawListsResponse>()
    val lawLists: LiveData<LawListsResponse> = _lawLists

    fun getLawLists() {
        viewModelScope.launch {
            val lawList = lawListsUseCase()
            _lawLists.value = lawList
        }
    }

    fun updateLawLists() {
        getLawLists()
    }
}
