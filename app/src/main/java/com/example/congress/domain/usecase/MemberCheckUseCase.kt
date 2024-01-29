package com.example.congress.domain.usecase

import com.example.congress.data.model.MemberCheckResponse
import com.example.congress.domain.repository.MemberCheckRepository
import javax.inject.Inject

class MemberCheckUseCase @Inject constructor(
    private val memberCheckRepository: MemberCheckRepository,
) {
    suspend operator fun invoke(
        userId: String,
    ): MemberCheckResponse {
        return memberCheckRepository.memberCheck(userId = userId)
    }
}