package com.example.congress.domain.usecase

import com.example.congress.data.model.CongressMemberDetailResponse
import com.example.congress.data.model.LawDetailResponse
import com.example.congress.domain.repository.LawDetailRepository
import com.example.congress.domain.repository.LawLegislatorDetailRepository
import javax.inject.Inject

class LawLegislatorDetailUseCase @Inject constructor(
    private val lawLegislatorDetailRepository: LawLegislatorDetailRepository,
) {
    suspend operator fun invoke(
        userId: String,
        legislatorName: String,
    ): CongressMemberDetailResponse {
        return lawLegislatorDetailRepository.lawLegislatorDetail(userId, legislatorName)
    }
}