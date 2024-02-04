package com.example.congress.data.repository

import com.example.congress.data.model.MyPageLegislatorResponse
import com.example.congress.data.network.ApiService
import com.example.congress.domain.repository.MyPageLegislatorRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyPageLegislatorRepositoryImpl @Inject constructor(
    private val service: ApiService
): MyPageLegislatorRepository {
    override suspend fun myLegislator(
        userId: String
    ): MyPageLegislatorResponse {
        return service.getMyPageLegislator(userId)
    }
}