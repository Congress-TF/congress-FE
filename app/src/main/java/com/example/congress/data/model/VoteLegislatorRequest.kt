package com.example.congress.data.model

import com.squareup.moshi.Json

data class VoteLegislatorRequest(
    @field:Json(name = "userId")
    val userId: String = "",
    @field:Json(name = "legislatorName")
    val legislatorName: String = "",
    @field:Json(name = "score")
    val score: Int = 0,
)