package com.example.congress.domain.usecase

import com.example.congress.data.model.VoteTotalResponse
import com.example.congress.domain.repository.VoteLegislatorTotalRepository
import javax.inject.Inject

class VoteLegislatorTotalUseCase @Inject constructor(
    private val voteLegislatorTotalRepository: VoteLegislatorTotalRepository
) {
    suspend operator fun invoke(
        legislatorName: String
    ) : VoteTotalResponse {
        return voteLegislatorTotalRepository.voteTotal(legislatorName)
    }
}