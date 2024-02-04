package com.example.congress.domain.usecase

import com.example.congress.data.model.MyPageLegislatorResponse
import com.example.congress.domain.repository.MyPageLegislatorRepository
import javax.inject.Inject

class MyPageLegislatorUseCaseUseCase @Inject constructor(
    private val myPageLegislatorRepository: MyPageLegislatorRepository
) {
    suspend operator fun invoke(
        userId: String
    ) : MyPageLegislatorResponse {
        return myPageLegislatorRepository.myLegislator(userId = userId)
    }
}