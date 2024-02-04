package com.example.congress.domain.repository

import com.example.congress.data.model.LawVoteResponse

interface LawVoteRepository {
    suspend fun lawVote(userId: String, lawName: String): LawVoteResponse
}