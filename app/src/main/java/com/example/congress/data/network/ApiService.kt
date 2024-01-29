package com.example.congress.data.network

import com.example.congress.data.model.MemberCheckResponse
import com.example.congress.data.model.MemberSignInRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("/v1/member/signin")
    suspend fun postMemberSignin(
        @Body initMemberModel: MemberSignInRequest
    )

    @GET("/v1/member/check")
    suspend fun getMemberCheck(
        @Query("userId") userId: String
    ): MemberCheckResponse
}