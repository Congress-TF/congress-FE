package com.example.congress.data.repository

import com.example.congress.data.model.MemberSignInRequest
import com.example.congress.data.network.ApiService
import com.example.congress.domain.repository.LoginRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepositoryImpl @Inject constructor(
    private val service: ApiService
): LoginRepository {
    override suspend fun userLogin(memberSignInRequest: MemberSignInRequest) {
        return service.postMemberSignin(memberSignInRequest)
    }
}