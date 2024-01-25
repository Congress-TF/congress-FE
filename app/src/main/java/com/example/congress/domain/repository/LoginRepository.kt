package com.example.congress.domain.repository

import com.example.congress.data.model.MemberSignInRequest

interface LoginRepository {
    suspend fun userLogin(memberSignInRequest: MemberSignInRequest)
}