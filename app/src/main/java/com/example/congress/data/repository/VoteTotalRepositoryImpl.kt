package com.example.congress.data.repository

import com.example.congress.data.network.ApiService
import com.example.congress.domain.repository.VoteTotalRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VoteTotalRepositoryImpl @Inject constructor(
    private val service: ApiService
): VoteTotalRepository {
    override suspend fun voteTotal() {
        TODO("Not yet implemented")
    }
}