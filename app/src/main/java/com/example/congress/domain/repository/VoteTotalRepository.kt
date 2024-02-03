package com.example.congress.domain.repository

import com.example.congress.data.model.VoteTotalResponse

interface VoteTotalRepository {
    suspend fun voteTotal(lawName: String): VoteTotalResponse
}