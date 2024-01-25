package com.example.congress.data.network

import com.example.congress.data.model.MemberSignInRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("/v1/member/signin")
    suspend fun postMemberSignin(
        @Body initMemberModel: MemberSignInRequest
    )

}