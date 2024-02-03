package com.example.congress.data.model

import com.squareup.moshi.Json

data class CongressMembersResponse(
    @field:Json(name = "result")
    val result: ApiResponse?,
    @field:Json(name = "payload")
    val payload: List<CongressMember>?
)

data class CongressMember(
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "section")
    val section: String,
    @field:Json(name = "unit")
    val unit: String,
    @field:Json(name = "score")
    val score: Int
)
