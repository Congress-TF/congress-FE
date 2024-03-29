package com.example.congress.data.network

import com.example.congress.data.model.CongressMemberDetailResponse
import com.example.congress.data.model.CongressMembersResponse
import com.example.congress.data.model.HashtagRankResponse
import com.example.congress.data.model.HashtagSaveRequest
import com.example.congress.data.model.HashtagSaveResponse
import com.example.congress.data.model.LawDetailResponse
import com.example.congress.data.model.LawListsResponse
import com.example.congress.data.model.LawVoteResponse
import com.example.congress.data.model.MemberCheckResponse
import com.example.congress.data.model.MemberMyInfoResponse
import com.example.congress.data.model.MemberSignInRequest
import com.example.congress.data.model.MyPageLegislatorResponse
import com.example.congress.data.model.MyPageVoteResponse
import com.example.congress.data.model.VoteLegislatorRequest
import com.example.congress.data.model.VoteRequest
import com.example.congress.data.model.VoteResponse
import com.example.congress.data.model.VoteTotalResponse
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
        @Body initMemberModel: MemberSignInRequest,
    )

    @DELETE("/v1/member/{sampleUserId}/signout")
    suspend fun deleteMemberSignOut(
        @Path("sampleUserId") sampleUserId: String,
    )

    @GET("/v1/member/check")
    suspend fun getMemberCheck(
        @Query("userId") userId: String,
    ): MemberCheckResponse

    @GET("/v1/member/myinfo")
    suspend fun getMemberMyInfo(
        @Query("userId") userId: String,
    ): MemberMyInfoResponse

    @PUT("/v1/member/update")
    suspend fun putMemberUpdate(
        @Body initMemberModel: MemberSignInRequest,
    )

    @POST("/v1/hashtag/save")
    suspend fun postHashtagSave(
        @Body hashtagSave: HashtagSaveRequest,
    ): HashtagSaveResponse

    @GET("/v1/hashtag/{name}/rank")
    suspend fun getHashtagRank(
        @Path("name") name: String,
    ): HashtagRankResponse

    @POST("/v1/vote")
    suspend fun postVote(
        @Body vote: VoteRequest,
    ): VoteResponse

    @GET("/v1/vote/{lawName}/total")
    suspend fun getVoteTotal(
        @Path("lawName") lawName: String,
    ): VoteTotalResponse

    @GET("/v1/law/voteresult")
    suspend fun getLawVoteResult(
        @Query("userId") userId: String,
        @Query("lawName") lawName: String,
    ): LawVoteResponse

    @GET("/v1/law/detail")
    suspend fun getLawDetail(
        @Query("userId") userId: String,
        @Query("lawName") lawName: String,
    ): LawDetailResponse

    @GET("/v1/law/lists")
    suspend fun getLawLists(): LawListsResponse

    @GET("/v1/law/legislator")
    suspend fun getLawLegislator(): CongressMembersResponse

    @GET("/v1/law/legislator/detail")
    suspend fun getLegislatorDetail(
        @Query("userId") userId: String,
        @Query("legislatorName") legislatorName: String,
    ): CongressMemberDetailResponse

    @POST("/v1/vote/legislator")
    suspend fun postVoteLegislator(
        @Body vote: VoteLegislatorRequest,
    ): VoteResponse

    @GET("/v1/vote/{legislatorName}/legislator/total")
    suspend fun getVoteLegislatorTotal(
        @Path("legislatorName") legislatorName: String,
    ): VoteTotalResponse

    @GET("/v1/mypage/vote")
    suspend fun getMyPageVote(
        @Query("userId") userId: String,
    ): MyPageVoteResponse

    @GET("/v1/mypage/legislator")
    suspend fun getMyPageLegislator(
        @Query("userId") userId: String,
    ): MyPageLegislatorResponse
}