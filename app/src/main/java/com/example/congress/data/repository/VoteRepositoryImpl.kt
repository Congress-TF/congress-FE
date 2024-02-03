package com.example.congress.data.repository

import com.example.congress.data.network.ApiService
import com.example.congress.domain.repository.VoteRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VoteRepositoryImpl @Inject constructor(
    private val service: ApiService
): VoteRepository {
    override suspend fun vote() {

    }
}