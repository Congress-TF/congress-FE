package com.example.congress.domain.usecase

import com.example.congress.data.model.VoteTotalResponse
import com.example.congress.domain.repository.VoteTotalRepository
import javax.inject.Inject

class VoteTotalUseCase @Inject constructor(
    private val voteTotalRepository: VoteTotalRepository
) {
    suspend operator fun invoke(
        name: String
    ) : VoteTotalResponse {
        return voteTotalRepository.voteTotal(name)
    }
}