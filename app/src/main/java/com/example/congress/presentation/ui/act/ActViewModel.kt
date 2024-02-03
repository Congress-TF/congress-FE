package com.example.congress.presentation.ui.act

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.congress.base.BaseViewModel
import com.example.congress.data.model.HashtagRankResponse
import com.example.congress.data.model.LawDetailResponse
import com.example.congress.domain.usecase.HashtagRankUseCase
import com.example.congress.domain.usecase.LawDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActViewModel @Inject constructor(
    private val hashtagRankUseCase: HashtagRankUseCase,
    private val lawDetailUseCase: LawDetailUseCase,
) : BaseViewModel() {
    private val _lawDetail = MutableLiveData<LawDetailResponse>()
    val lawDetail: LiveData<LawDetailResponse> = _lawDetail

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


    fun getHashtagRank(name: String) {
        viewModelScope.launch {
            val rank = hashtagRankUseCase(name)
            _hashtagRank.value = rank
        }
    }
}