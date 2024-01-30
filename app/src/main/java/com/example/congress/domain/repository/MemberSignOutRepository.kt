package com.example.congress.domain.repository

interface MemberSignOutRepository {
    suspend fun memberSignOut(sampleUserId: String)
}