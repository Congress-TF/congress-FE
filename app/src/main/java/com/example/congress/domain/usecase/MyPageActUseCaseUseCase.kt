package com.example.congress.domain.usecase

import com.example.congress.data.model.MyPageVoteResponse
import com.example.congress.domain.repository.MyPageActRepository
import javax.inject.Inject

class MyPageActUseCaseUseCase @Inject constructor(
    private val myPageActRepository: MyPageActRepository
) {
    suspend operator fun invoke(
        userId: String
    ) : MyPageVoteResponse {
        return myPageActRepository.myActList(userId = userId)
    }
}