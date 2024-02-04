package com.example.congress.domain.repository

import com.example.congress.data.model.VoteLegislatorRequest
import com.example.congress.data.model.VoteResponse

interface VoteLegislatorRepository {
    suspend fun vote(voteRequest: VoteLegislatorRequest): VoteResponse
}