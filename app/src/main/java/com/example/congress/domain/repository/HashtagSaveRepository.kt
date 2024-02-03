package com.example.congress.domain.repository

import com.example.congress.data.model.HashtagSaveRequest
import com.example.congress.data.model.HashtagSaveResponse

interface HashtagSaveRepository {
    suspend fun hashtagSave(hashtag: HashtagSaveRequest): HashtagSaveResponse
}