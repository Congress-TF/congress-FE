package com.example.congress.domain.repository

import com.example.congress.data.model.CongressMember

interface LawLegislatorRepository {
    suspend fun lawLegislator() : CongressMember
}