package com.example.congress.domain.repository

import com.example.congress.data.model.CongressMemberDetailResponse
import com.example.congress.data.model.LawDetailResponse

interface LawLegislatorDetailRepository {
    suspend fun lawLegislatorDetail(userId: String, legislatorName: String) : CongressMemberDetailResponse
}