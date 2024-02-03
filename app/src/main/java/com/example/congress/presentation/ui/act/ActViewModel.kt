package com.example.congress.presentation.ui.act

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.congress.base.BaseViewModel
import com.example.congress.data.model.HashtagRankResponse
import com.example.congress.domain.usecase.HashtagRankUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActViewModel @Inject constructor(
    private val hashtagRankUseCase: HashtagRankUseCase,
) : BaseViewModel() {
    private val _hashtagRank = MutableLiveData<HashtagRankResponse>()
    val hashtagRank: LiveData<HashtagRankResponse> = _hashtagRank

    fun getHashtagRank(name: String) {
        viewModelScope.launch {
            val rank = hashtagRankUseCase(name)
            _hashtagRank.value = rank

        }
    }
}