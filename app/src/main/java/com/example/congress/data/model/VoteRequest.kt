package com.example.congress.data.model

import com.squareup.moshi.Json

data class VoteRequest(
    @field:Json(name = "userId")
    val userId: String = "",
    @field:Json(name = "lawId")
    val lawId: Long = 0,
    @field:Json(name = "score")
    val score: Int = 0,
)