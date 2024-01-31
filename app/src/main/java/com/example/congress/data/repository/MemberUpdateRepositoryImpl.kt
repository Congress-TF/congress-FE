package com.example.congress.data.repository

import com.example.congress.data.model.MemberSignInRequest
import com.example.congress.data.network.ApiService
import com.example.congress.domain.repository.MemberUpdateRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MemberUpdateRepositoryImpl @Inject constructor(
    private val service: ApiService
): MemberUpdateRepository {
    override suspend fun memberUpdate(memberUpdate: MemberSignInRequest) {
        return service.putMemberUpdate(memberUpdate)
    }
}