package com.example.congress.data.repository

import com.example.congress.data.network.ApiService
import com.example.congress.domain.repository.LawLegislatorRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LawLegislatorRepositoryImpl @Inject constructor(
    private val service: ApiService
): LawLegislatorRepository {
    override suspend fun lawLegislator() {
        TODO("Not yet implemented")
    }
}