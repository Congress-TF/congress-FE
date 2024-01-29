package com.example.congress.data.repository

import com.example.congress.data.model.MemberCheckResponse
import com.example.congress.data.network.ApiService
import com.example.congress.domain.repository.MemberCheckRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MemberCheckRepositoryImpl @Inject constructor(
    private val service: ApiService
): MemberCheckRepository {
    override suspend fun memberCheck(
        userId: String
    ): MemberCheckResponse {
        return service.getMemberCheck(
            userId
        )
    }
}