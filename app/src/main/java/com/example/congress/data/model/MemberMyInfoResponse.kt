package com.example.congress.data.model

import com.squareup.moshi.Json

data class MemberMyInfoResponse(
    @field:Json(name = "result")
    val result: ApiResponse?,
    @field:Json(name = "payload")
    val payload: Payload?
)

data class Payload(
    @field:Json(name = "nickname")
    val nickname: String?,
    @field:Json(name = "gender")
    val gender: String?,
    @field:Json(name = "year")
    val year: String?
)
