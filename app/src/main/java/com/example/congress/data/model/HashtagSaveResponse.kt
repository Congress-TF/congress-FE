package com.example.congress.data.model

import com.squareup.moshi.Json

data class HashtagSaveResponse(
    @field:Json(name = "result")
    val result: ApiResponse?,
    @field:Json(name = "payload")
    val payload: Long?,
)