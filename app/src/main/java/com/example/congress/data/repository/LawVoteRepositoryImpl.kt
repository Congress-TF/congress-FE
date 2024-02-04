package com.example.congress.data.repository

import com.example.congress.data.model.LawVoteResponse
import com.example.congress.data.network.ApiService
import com.example.congress.domain.repository.LawVoteRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LawVoteRepositoryImpl @Inject constructor(
    private val service: ApiService
): LawVoteRepository {
    override suspend fun lawVote(
        userId: String,
        lawName: String
    ) : LawVoteResponse {
        return service.getLawVoteResult(userId, lawName)
    }
}