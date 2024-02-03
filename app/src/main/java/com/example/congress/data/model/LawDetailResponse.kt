package com.example.congress.data.model

import com.squareup.moshi.Json

data class LawDetailResponse(
    @field:Json(name = "result")
    val result: ApiResponse?,
    @field:Json(name = "payload")
    val payload: LawDetailPayload?,
)

data class LawDetailPayload(
    @field:Json(name = "billNo")
    val billNo: String,
    @field:Json(name = "billNm")
    val billNm: String,
    @field:Json(name = "proposer")
    val proposer: String,
    @field:Json(name = "proposerDt")
    val proposerDt: String,
    @field:Json(name = "detailLink")
    val detailLink: String,
)