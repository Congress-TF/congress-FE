package com.example.congress.domain.repository

import com.example.congress.data.model.VoteRequest

interface VoteRepository {
    suspend fun vote(voteRequest: VoteRequest)
}