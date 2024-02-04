package com.example.congress.domain.repository

import com.example.congress.data.model.VoteTotalResponse

interface VoteLegislatorTotalRepository {
    suspend fun voteTotal(legislatorName: String): VoteTotalResponse
}