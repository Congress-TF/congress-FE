package com.example.congress.data.repository

import com.example.congress.data.network.ApiService
import com.example.congress.domain.repository.MemberSignOutRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MemberSignOutRepositoryImpl @Inject constructor(
    private val service: ApiService
): MemberSignOutRepository {
    override suspend fun memberSignOut(sampleUserId: String) {
        return service.deleteMemberSignOut(sampleUserId)
    }
}