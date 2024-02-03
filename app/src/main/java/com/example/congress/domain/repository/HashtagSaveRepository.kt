package com.example.congress.domain.repository

import com.example.congress.data.model.HashtagSaveRequest

interface HashtagSaveRepository {
    suspend fun hashtagSave(hashtag: HashtagSaveRequest)
}