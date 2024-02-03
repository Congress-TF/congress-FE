package com.example.congress.presentation.ui.revision

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.congress.base.BaseViewModel
import com.example.congress.data.model.CongressMembersResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RevisionViewModel @Inject constructor(
) : BaseViewModel() {
    private val _lawLegislator = MutableLiveData<CongressMembersResponse>()
    val lawLegislator: LiveData<CongressMembersResponse> = _lawLegislator

}