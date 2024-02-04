package com.example.congress.data.repository

import com.example.congress.data.model.VoteTotalResponse
import com.example.congress.data.network.ApiService
import com.example.congress.domain.repository.VoteLegislatorTotalRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VoteLegislatorTotalRepositoryImpl @Inject constructor(
    private val service: ApiService
): VoteLegislatorTotalRepository {
    override suspend fun voteTotal(legislatorName: String): VoteTotalResponse {
        return service.getVoteLegislatorTotal(
            legislatorName
        )
    }
}