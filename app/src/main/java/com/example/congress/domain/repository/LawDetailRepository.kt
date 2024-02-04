package com.example.congress.domain.repository

import com.example.congress.data.model.LawDetailResponse

interface LawDetailRepository {
    suspend fun lawDetail(userId: String, lawName: String) : LawDetailResponse
}