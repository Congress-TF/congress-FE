package com.example.congress.data.model


import com.squareup.moshi.Json

data class ApiResponse(
    @field:Json(name = "code")
    val code: Int?,
    @field:Json(name = "message")
    val message: String?,
)