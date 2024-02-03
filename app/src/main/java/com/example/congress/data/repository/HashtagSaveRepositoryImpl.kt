package com.example.congress.data.repository

import com.example.congress.data.model.HashtagSaveRequest
import com.example.congress.data.network.ApiService
import com.example.congress.domain.repository.HashtagSaveRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HashtagSaveRepositoryImpl @Inject constructor(
    private val service: ApiService
): HashtagSaveRepository {
    override suspend fun hashtagSave(hashtag: HashtagSaveRequest) {
        return service.postHashtagSave(hashtag)
    }
}