package com.example.congress.data.repository

import com.example.congress.data.model.MemberSignInRequest
import com.example.congress.data.network.ApiService
import com.example.congress.domain.repository.MemberSignInRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MemberSignInRepositoryImpl @Inject constructor(
    private val service: ApiService
): MemberSignInRepository {
    override suspend fun memberSignIn(memberSignInRequest: MemberSignInRequest) {
        return service.postMemberSignin(memberSignInRequest)
    }
}