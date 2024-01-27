package com.example.congress.data.repository

import com.example.congress.data.model.TestResponse
import com.example.congress.data.network.ApiService
import com.example.congress.domain.repository.TestRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestRepositoryImpl @Inject constructor(
    private val service: ApiService
) : TestRepository {
    override suspend fun test() : TestResponse {
        return service.getTest()
    }
}