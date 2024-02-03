package com.example.congress.data.model

import com.squareup.moshi.Json

data class MyPageLegislatorResponse(
    @field:Json(name = "result")
    val result: ApiResponse?,
    @field:Json(name = "payload")
    val payload: MyPageLegislatorPayload?,
)

data class MyPageLegislatorPayload(
    @field:Json(name = "legislatorName")
    val legislatorName: String,
    @field:Json(name = "score")
    val score: Int,
    @field:Json(name = "totalScore")
    val totalScore: Int
)