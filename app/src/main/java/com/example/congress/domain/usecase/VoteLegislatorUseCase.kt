package com.example.congress.domain.usecase

import com.example.congress.data.model.VoteLegislatorRequest
import com.example.congress.data.model.VoteResponse
import com.example.congress.domain.repository.VoteLegislatorRepository
import javax.inject.Inject

class VoteLegislatorUseCase @Inject constructor(
    private val voteLegislatorRepository: VoteLegislatorRepository
) {
    suspend operator fun invoke(
        voteRequest: VoteLegislatorRequest
    ) : VoteResponse {
       return voteLegislatorRepository.vote(voteRequest)
    }
}