package com.example.congress.presentation.ui.revision

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.congress.base.BaseViewModel
import com.example.congress.data.model.CongressMemberDetailResponse
import com.example.congress.domain.usecase.LawLegislatorDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RevisionViewModel @Inject constructor(
    private val lawLegislatorDetailUseCase: LawLegislatorDetailUseCase
) : BaseViewModel() {
    private val _lawLegislator = MutableLiveData<CongressMemberDetailResponse>()
    val lawLegislator: LiveData<CongressMemberDetailResponse> = _lawLegislator

    fun getLegislatorMemberDetail(
        userId: String,
        legislatorName: String
    ) {
        viewModelScope.launch {
            val detail = lawLegislatorDetailUseCase(
                userId, legislatorName
            )
            _lawLegislator.value = detail
        }
    }
}