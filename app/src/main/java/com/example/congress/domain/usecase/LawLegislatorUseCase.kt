package com.example.congress.domain.usecase

import com.example.congress.data.model.CongressMember
import com.example.congress.domain.repository.LawLegislatorRepository
import javax.inject.Inject

class LawLegislatorUseCase @Inject constructor(
    private val lawLegislatorRepository: LawLegislatorRepository
) {
    suspend operator fun invoke() : CongressMember {
        return lawLegislatorRepository.lawLegislator()
    }
}