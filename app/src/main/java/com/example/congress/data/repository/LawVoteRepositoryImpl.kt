package com.example.congress.data.repository

import com.example.congress.data.network.ApiService
import com.example.congress.domain.repository.LawVoteRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LawVoteRepositoryImpl @Inject constructor(
    private val service: ApiService
): LawVoteRepository {
    override suspend fun lawVote() {
        TODO("Not yet implemented")
    }
}