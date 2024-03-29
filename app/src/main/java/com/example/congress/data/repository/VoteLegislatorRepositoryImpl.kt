package com.example.congress.data.repository

import com.example.congress.data.model.VoteLegislatorRequest
import com.example.congress.data.model.VoteResponse
import com.example.congress.data.network.ApiService
import com.example.congress.domain.repository.VoteLegislatorRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VoteLegislatorRepositoryImpl @Inject constructor(
    private val service: ApiService
): VoteLegislatorRepository {
    override suspend fun vote(voteRequest: VoteLegislatorRequest) : VoteResponse {
        return service.postVoteLegislator(voteRequest)
    }
}