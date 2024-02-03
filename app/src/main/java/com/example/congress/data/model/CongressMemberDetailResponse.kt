package com.example.congress.data.model

import com.squareup.moshi.Json

data class CongressMemberDetailResponse(
    @field:Json(name = "result")
    val result: ApiResponse?,
    @field:Json(name = "payload")
    val payload: CongressMemberDetailPayload?
)

data class CongressMemberDetailPayload(
    @field:Json(name = "hgNm")
    val hgNm: String,
    @field:Json(name = "bthDate")
    val bthDate: String,
    @field:Json(name = "sexGbnNm")
    val sexGbnNm: String,
    @field:Json(name = "reeleGbnNm")
    val reeleGbnNm: String,
    @field:Json(name = "units")
    val units: String,
    @field:Json(name = "unitNm")
    val unitNm: String,
    @field:Json(name = "polyNm")
    val polyNm: String,
    @field:Json(name = "origNm")
    val origNm: String,
    @field:Json(name = "ftToDateOne")
    val ftToDateOne: String,
    @field:Json(name = "profileSjOne")
    val profileSjOne: String,
    @field:Json(name = "frToDateTwo")
    val frToDateTwo: String,
    @field:Json(name = "profileSjTwo")
    val profileSjTwo: String
)
