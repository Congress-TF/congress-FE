package com.example.congress.data.repository

import com.example.congress.data.network.ApiService
import com.example.congress.domain.repository.LawListsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LawListsRepositoryImpl @Inject constructor(
    private val service: ApiService
): LawListsRepository {
    override suspend fun lawLists() {
        TODO("Not yet implemented")
    }

}