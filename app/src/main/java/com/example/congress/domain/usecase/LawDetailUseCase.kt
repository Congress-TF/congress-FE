package com.example.congress.domain.usecase

import com.example.congress.data.model.LawDetailResponse
import com.example.congress.domain.repository.LawDetailRepository
import javax.inject.Inject

class LawDetailUseCase @Inject constructor(
    private val lawDetailRepository: LawDetailRepository
) {
    suspend operator fun invoke(
        userId: String,
        lawName: String,
    ) :LawDetailResponse {
        return lawDetailRepository.lawDetail(userId, lawName)
    }
}