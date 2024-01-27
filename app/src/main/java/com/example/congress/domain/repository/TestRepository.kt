package com.example.congress.domain.repository

import com.example.congress.data.model.TestResponse

interface TestRepository {
    suspend fun test() : TestResponse
}