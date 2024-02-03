package com.example.congress.data.repository

import com.example.congress.data.model.HashtagRankResponse
import com.example.congress.data.network.ApiService
import com.example.congress.domain.repository.HashtagRankRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HashtagRankRepositoryImpl @Inject constructor(
    private val service: ApiService,
) : HashtagRankRepository {
    override suspend fun hashtagRank(name: String): HashtagRankResponse {
        return service.getHashtagRank(
            name
        )
    }
}