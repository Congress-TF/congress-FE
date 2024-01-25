package com.example.congress.data.model


data class MemberSignInRequest(
    val nickname: String,
    val gender: String,
    val year: String,
    val email: String,
    val intend: String,
)