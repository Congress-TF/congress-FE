package com.example.congress.data.network

import com.example.congress.data.model.MemberSignInRequest
import com.example.congress.data.model.TestResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("/v1/member/signin")
    suspend fun postMemberSignin(
        @Body initMemberModel: MemberSignInRequest
    )

    @GET("/v1/test")
    suspend fun getTest(): TestResponse


}