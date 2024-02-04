package com.example.congress.domain.repository

import com.example.congress.data.model.MyPageVoteResponse

interface MyPageActRepository {
    suspend fun myActList(userId: String) : MyPageVoteResponse
}