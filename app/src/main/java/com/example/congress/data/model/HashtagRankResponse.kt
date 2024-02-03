package com.example.congress.data.model

import com.squareup.moshi.Json

data class HashtagRankResponse (
    @field:Json(name = "result")
    val result: ApiResponse?,
    @field:Json(name = "payload")
    val payload: HashtagRankPayload?
)

data class HashtagRankPayload(
    @field:Json(name = "tag")
    val nickname: String?,
    @field:Json(name = "count")
    val gender: Int?,
)
