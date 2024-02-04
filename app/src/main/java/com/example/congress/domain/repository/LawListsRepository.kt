package com.example.congress.domain.repository

import com.example.congress.data.model.LawListsResponse

interface LawListsRepository {
    suspend fun lawLists() : LawListsResponse
}