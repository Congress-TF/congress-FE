package com.example.congress.domain.repository

import com.example.congress.data.model.MemberSignInRequest

interface MemberUpdateRepository {
    suspend fun memberUpdate(memberUpdate: MemberSignInRequest)
}