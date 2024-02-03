package com.example.congress.data.model

import com.squareup.moshi.Json

data class LawVoteResponse(
    @field:Json(name = "result")
    val result: ApiResponse?,
    @field:Json(name = "payload")
    val payload: LawVotePayload?
)


data class LawVotePayload(
    @field:Json(name = "billNm")
    val billNm: String?,
    @field:Json(name = "yesCount")
    val yesCount: String?
)