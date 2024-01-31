package com.example.congress.domain.repository

import com.example.congress.data.model.MemberMyInfoResponse

interface MemberMyInfoRepository {
    suspend fun memberMyInfo(userId: String): MemberMyInfoResponse
}