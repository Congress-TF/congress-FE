package com.example.congress.data.model

import com.squareup.moshi.Json


data class MemberSignInRequest(
    @field:Json(name = "nickname")
    val nickname: String = "",
    @field:Json(name = "gender")
    val gender: String = "",
    @field:Json(name = "year")
    val year: String = "",
    @field:Json(name = "userId")
    val userId: String = "",
)