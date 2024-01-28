package com.example.congress.domain.repository

import com.example.congress.data.model.MemberCheckResponse

interface MemberCheckRepository {
    suspend fun memberCheck(userId: Int): MemberCheckResponse
}