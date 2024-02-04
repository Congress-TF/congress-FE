package com.example.congress.domain.usecase

import com.example.congress.data.model.VoteRequest
import com.example.congress.data.model.VoteResponse
import com.example.congress.domain.repository.VoteLegislatorRepository
import javax.inject.Inject

class VoteLegislatorUseCase @Inject constructor(
    private val voteLegislatorRepository: VoteLegislatorRepository
) {
    suspend operator fun invoke(
        voteRequest: VoteRequest
    ) : VoteResponse {
       return voteLegislatorRepository.vote(voteRequest)
    }
}