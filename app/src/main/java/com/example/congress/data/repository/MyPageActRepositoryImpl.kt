package com.example.congress.data.repository

import com.example.congress.data.model.MyPageVoteResponse
import com.example.congress.data.network.ApiService
import com.example.congress.domain.repository.MyPageActRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyPageActRepositoryImpl @Inject constructor(
    private val service: ApiService
): MyPageActRepository {
    override suspend fun myActList(
        userId: String
    ): MyPageVoteResponse {
        return service.getMyPageVote(userId)
    }
}