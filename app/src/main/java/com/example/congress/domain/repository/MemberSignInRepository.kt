package com.example.congress.domain.repository

import com.example.congress.data.model.MemberSignInRequest

interface MemberSignInRepository {
    suspend fun memberSignIn(memberSignInRequest: MemberSignInRequest)
}