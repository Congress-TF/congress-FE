package com.example.congress.presentation.ui.act

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.congress.base.BaseViewModel
import com.example.congress.data.model.HashtagRankResponse
import com.example.congress.data.model.HashtagSaveRequest
import com.example.congress.data.model.LawDetailResponse
import com.example.congress.data.model.LawVoteResponse
import com.example.congress.data.model.VoteRequest
import com.example.congress.data.model.VoteTotalResponse
import com.example.congress.domain.usecase.HashtagRankUseCase
import com.example.congress.domain.usecase.HashtagSaveUseCase
import com.example.congress.domain.usecase.LawDetailUseCase
import com.example.congress.domain.usecase.LawVoteUseCase
import com.example.congress.domain.usecase.VoteTotalUseCase
import com.example.congress.domain.usecase.VoteUseCase
import com.example.congress.presentation.ui.home.HomeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActViewModel @Inject constructor(
    private val hashtagRankUseCase: HashtagRankUseCase,
    private val lawDetailUseCase: LawDetailUseCase,
    private val voteTotalUseCase: VoteTotalUseCase,
    private val lawVoteUseCase: LawVoteUseCase,
    private val voteUseCase: VoteUseCase,
    private val hashtagSaveUseCase: HashtagSaveUseCase,
) : BaseViewModel() {
    private val _lawDetail = MutableLiveData<LawDetailResponse>()
    val lawDetail: LiveData<LawDetailResponse> = _lawDetail

    private val _lawVote = MutableLiveData<LawVoteResponse>()
    val lawVote: LiveData<LawVoteResponse> = _lawVote

    private val _voteTotal = MutableLiveData<VoteTotalResponse>()
    val voteTotal: LiveData<VoteTotalResponse> = _voteTotal

    private val _hashtagRank = MutableLiveData<HashtagRankResponse>()
    val hashtagRank: LiveData<HashtagRankResponse> = _hashtagRank

    private val _hashtag = MutableLiveData<String>()
    val hashtag: LiveData<String> = _hashtag

    fun setHashtag(hashtag: String) {
        _hashtag.value = hashtag
    }

    fun getLawDetail(
        userId: String,
        lawName: String,
    ) {
        viewModelScope.launch {
            val detail = lawDetailUseCase(
                userId, lawName
            )
            _lawDetail.value = detail
        }
    }

    fun getLawVote(
        userId: String,
        lawName: String,
    ) {
        viewModelScope.launch {
            val lawVote = lawVoteUseCase(
                userId, lawName
            )
            lawVote?.let {
                _lawVote.value = lawVote
            }
        }
    }

    fun getVoteTotal(
        lawName: String,
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

    fun postVote(
        voteRequest: VoteRequest,
        onSuccess: () -> Unit,
        onError: () -> Unit,
    ) {
        viewModelScope.launch {
            try {
                val response = voteUseCase.invoke(voteRequest)
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


    fun postHashtagSave(
        hashtagSaveRequest: HashtagSaveRequest,
        onSuccess: () -> Unit,
        onError: () -> Unit,
    ) {
        viewModelScope.launch {
            try {
                val response = hashtagSaveUseCase.invoke(hashtagSaveRequest)
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