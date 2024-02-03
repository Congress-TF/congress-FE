package com.example.congress.domain.usecase

import com.example.congress.data.model.VoteRequest
import com.example.congress.data.model.VoteResponse
import com.example.congress.domain.repository.VoteRepository
import javax.inject.Inject

class VoteUseCase @Inject constructor(
    private val voteRepository: VoteRepository
) {
    suspend operator fun invoke(
        voteRequest: VoteRequest
    ) : VoteResponse {
       return voteRepository.vote(voteRequest)
    }
}