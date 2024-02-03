package com.example.congress.data.model

import com.squareup.moshi.Json

data class HashtagSaveRequest(
    @field:Json(name = "userId")
    val userId: String = "",
    @field:Json(name = "lawName")
    val lawName: String = "",
    @field:Json(name = "tag")
    val tag: String = "",
)