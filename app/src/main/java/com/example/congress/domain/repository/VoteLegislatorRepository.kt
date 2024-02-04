package com.example.congress.domain.repository

import com.example.congress.data.model.VoteRequest
import com.example.congress.data.model.VoteResponse

interface VoteLegislatorRepository {
    suspend fun vote(voteRequest: VoteRequest): VoteResponse
}