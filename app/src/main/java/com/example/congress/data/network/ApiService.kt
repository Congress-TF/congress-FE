package com.example.congress.data.network

import com.example.congress.data.model.MemberCheckResponse
import com.example.congress.data.model.MemberMyInfoResponse
import com.example.congress.data.model.MemberSignInRequest
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @POST("/v1/member/signin")
    suspend fun postMemberSignin(
        @Body initMemberModel: MemberSignInRequest
    )

    @DELETE("/v1/member/{sampleUserId}/signout")
    suspend fun deleteMemberSignOut(
        @Path("sampleUserId") sampleUserId: String
    )

    @GET("/v1/member/check")
    suspend fun getMemberCheck(
        @Query("userId") userId: String
    ): MemberCheckResponse

    @GET("/v1/member/myinfo")
    suspend fun getMemberMyInfo(
        @Query("userId") userId: String
    ): MemberMyInfoResponse

    @PUT("/v1/member/update")
    suspend fun putMemberUpdate(
        @Body initMemberModel: MemberSignInRequest
    )
}