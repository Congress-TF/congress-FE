package com.example.congress.data.repository

import com.example.congress.data.model.LawDetailResponse
import com.example.congress.data.network.ApiService
import com.example.congress.domain.repository.LawDetailRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LawDetailRepositoryImpl @Inject constructor(
    private val service: ApiService
): LawDetailRepository {
    override suspend fun lawDetail(
        userId: String,
        lawName: String,
    ) : LawDetailResponse {
        return service.getLawDetail(
            userId, lawName
        )
    }
}