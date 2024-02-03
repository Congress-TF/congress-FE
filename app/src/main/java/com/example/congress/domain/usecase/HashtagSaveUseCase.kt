package com.example.congress.domain.usecase

import com.example.congress.data.model.HashtagSaveRequest
import com.example.congress.data.model.HashtagSaveResponse
import com.example.congress.domain.repository.HashtagSaveRepository
import javax.inject.Inject

class HashtagSaveUseCase @Inject constructor(
    private val hashtagSaveRepository: HashtagSaveRepository
) {
    suspend operator fun invoke(
        hashtagSaveRequest: HashtagSaveRequest
    ) : HashtagSaveResponse {
        return hashtagSaveRepository.hashtagSave(hashtagSaveRequest)
    }
}