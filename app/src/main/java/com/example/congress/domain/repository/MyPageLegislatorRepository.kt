package com.example.congress.domain.repository

import com.example.congress.data.model.MyPageLegislatorResponse

interface MyPageLegislatorRepository {
    suspend fun myLegislator(userId: String) : MyPageLegislatorResponse
}