package com.example.congress.domain.usecase

import com.example.congress.data.model.HashtagRankResponse
import com.example.congress.domain.repository.HashtagRankRepository
import javax.inject.Inject

class HashtagRankUseCase @Inject constructor(
    private val hashtagRankRepository: HashtagRankRepository
) {
    suspend operator fun invoke(
        id: String
    ) : HashtagRankResponse {
        return hashtagRankRepository.hashtagRank(id)
    }
}