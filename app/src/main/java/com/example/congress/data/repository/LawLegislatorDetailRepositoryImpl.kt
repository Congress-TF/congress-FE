package com.example.congress.data.repository

import com.example.congress.data.model.CongressMemberDetailResponse
import com.example.congress.data.model.LawDetailResponse
import com.example.congress.data.network.ApiService
import com.example.congress.domain.repository.LawDetailRepository
import com.example.congress.domain.repository.LawLegislatorDetailRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LawLegislatorDetailRepositoryImpl @Inject constructor(
    private val service: ApiService
): LawLegislatorDetailRepository {
    override suspend fun lawLegislatorDetail(
        userId: String,
        legislatorName: String,
    ): CongressMemberDetailResponse {
        return service.getLegislatorDetail(
            userId, legislatorName
        )
    }

}