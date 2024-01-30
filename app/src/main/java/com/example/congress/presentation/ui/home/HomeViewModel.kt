package com.example.congress.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.congress.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
) : BaseViewModel() {

    private val _isAct = MutableLiveData<Boolean>()
    val isAct: LiveData<Boolean> = _isAct

    private val _isRevision = MutableLiveData<Boolean>()
    val isRevision: LiveData<Boolean> = _isRevision

    fun onClickActButton() {
        _isAct.value != _isAct.value
    }
}