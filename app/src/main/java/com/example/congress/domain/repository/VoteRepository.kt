package com.example.congress.domain.repository

interface VoteRepository {
    suspend fun vote()
}