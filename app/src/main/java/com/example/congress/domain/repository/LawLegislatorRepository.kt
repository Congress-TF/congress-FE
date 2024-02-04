package com.example.congress.domain.repository

import com.example.congress.data.model.CongressMembersResponse

interface LawLegislatorRepository {
    suspend fun lawLegislator() : CongressMembersResponse
}