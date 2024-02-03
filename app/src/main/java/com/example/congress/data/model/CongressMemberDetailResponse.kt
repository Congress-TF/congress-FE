package com.example.congress.data.model

import com.squareup.moshi.Json

data class CongressMemberDetailResponse(
    @field:Json(name = "result")
    val result: ApiResponse?,
    @field:Json(name = "payload")
    val payload: CongressMemberDetailPayload?
)

data class CongressMemberDetailPayload(
    val hgNm: String,
    val bthDate: String,
    val sexGbnNm: String,
    val reeleGbnNm: String,
    val units: String,
    val unitNm: String,
    val polyNm: String,
    val origNm: String,
    val ftToDateOne: String,
    val profileSjOne: String,
    val frToDateTwo: String,
    val profileSjTwo: String
)
