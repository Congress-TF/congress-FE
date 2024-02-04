package com.example.congress.presentation.ui.revision

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.congress.base.BaseViewModel
import com.example.congress.data.model.CongressMemberDetailResponse
import com.example.congress.data.model.VoteRequest
import com.example.congress.data.model.VoteTotalResponse
import com.example.congress.domain.usecase.LawLegislatorDetailUseCase
import com.example.congress.domain.usecase.VoteLegislatorTotalUseCase
import com.example.congress.domain.usecase.VoteLegislatorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RevisionViewModel @Inject constructor(
    private val lawLegislatorDetailUseCase: LawLegislatorDetailUseCase,
    private val voteLegislatorUseCase: VoteLegislatorUseCase,
    private val voteLegislatorTotalUseCase: VoteLegislatorTotalUseCase
) : BaseViewModel() {
    private val _lawLegislator = MutableLiveData<CongressMemberDetailResponse>()
    val lawLegislator: LiveData<CongressMemberDetailResponse> = _lawLegislator

    private val _voteTotal = MutableLiveData<VoteTotalResponse>()
    val voteTotal: LiveData<VoteTotalResponse> = _voteTotal

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

    fun getVoteLegislatorTotal(
        legislatorName: String,
    ) {
        viewModelScope.launch {
            val voteTotal = voteLegislatorTotalUseCase(legislatorName)
            _voteTotal.value = voteTotal
        }
    }

    fun postVote(
        voteRequest: VoteRequest,
        onSuccess: () -> Unit,
        onError: () -> Unit,
    ) {
        viewModelScope.launch {
            try {
                val response = voteLegislatorUseCase.invoke(voteRequest)
                if (response.result?.code == 200) {
                    onSuccess.invoke()
                } else {
                    onError.invoke()
                }
            } catch (e: Exception) {
                onError.invoke()
            }
        }
    }
}