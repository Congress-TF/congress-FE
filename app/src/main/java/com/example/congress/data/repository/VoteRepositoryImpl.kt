package com.example.congress.data.repository

import com.example.congress.data.model.VoteRequest
import com.example.congress.data.model.VoteResponse
import com.example.congress.data.network.ApiService
import com.example.congress.domain.repository.VoteRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VoteRepositoryImpl @Inject constructor(
    private val service: ApiService
): VoteRepository {
    override suspend fun vote(voteRequest: VoteRequest) : VoteResponse {
        return service.postVote(voteRequest)
    }
}