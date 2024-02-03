package com.example.congress.presentation.ui.act

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.congress.base.BaseViewModel
import com.example.congress.data.model.HashtagRankResponse
import com.example.congress.data.model.LawDetailResponse
import com.example.congress.data.model.VoteTotalResponse
import com.example.congress.domain.usecase.HashtagRankUseCase
import com.example.congress.domain.usecase.LawDetailUseCase
import com.example.congress.domain.usecase.VoteTotalUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActViewModel @Inject constructor(
    private val hashtagRankUseCase: HashtagRankUseCase,
    private val lawDetailUseCase: LawDetailUseCase,
    private val voteTotalUseCase: VoteTotalUseCase
) : BaseViewModel() {
    private val _lawDetail = MutableLiveData<LawDetailResponse>()
    val lawDetail: LiveData<LawDetailResponse> = _lawDetail

    private val _voteTotal = MutableLiveData<VoteTotalResponse>()
    val voteTotal: LiveData<VoteTotalResponse> = _voteTotal

    private val _hashtagRank = MutableLiveData<HashtagRankResponse>()
    val hashtagRank: LiveData<HashtagRankResponse> = _hashtagRank

    fun getLawDetail(
        userId: String,
        lawName: String
    ) {
        viewModelScope.launch {
            val detail = lawDetailUseCase(
                userId, lawName
            )
            _lawDetail.value = detail
        }
    }

    fun getVoteTotal(
        lawName: String
    ) {
        viewModelScope.launch {
            val voteTotal = voteTotalUseCase(lawName)
            _voteTotal.value = voteTotal
        }
    }


    fun getHashtagRank(lawName: String) {
        viewModelScope.launch {
            val rank = hashtagRankUseCase(lawName)
            _hashtagRank.value = rank
        }
    }
}