package com.example.congress.domain.repository

import com.example.congress.data.model.HashtagRankResponse

interface HashtagRankRepository {
    suspend fun hashtagRank(id: String): HashtagRankResponse
}