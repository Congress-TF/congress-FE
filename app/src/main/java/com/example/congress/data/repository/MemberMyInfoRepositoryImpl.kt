package com.example.congress.data.repository

import com.example.congress.data.model.MemberMyInfoResponse
import com.example.congress.data.network.ApiService
import com.example.congress.domain.repository.MemberMyInfoRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MemberMyInfoRepositoryImpl @Inject constructor(
    private val service: ApiService
): MemberMyInfoRepository {
    override suspend fun memberMyInfo(
        userId: String
    ): MemberMyInfoResponse {
        return service.getMemberMyInfo(
            userId
        )
    }
}