package com.example.congress.data.model

import com.squareup.moshi.Json

data class MyPageVoteResponse(
    @field:Json(name = "result")
    val result: ApiResponse?,
    @field:Json(name = "payload")
    val payload: MyPageVotePayload?,
)

data class MyPageVotePayload(
    @field:Json(name = "lawName")
    val lawName: String,
    @field:Json(name = "score")
    val score: Int,
    @field:Json(name = "hashtag")
    val hashtag: String,
    @field:Json(name = "totalScore")
    val totalScore: Int
)