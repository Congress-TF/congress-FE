package com.example.congress.domain.usecase

import com.example.congress.data.model.LawListsResponse
import com.example.congress.domain.repository.LawListsRepository
import javax.inject.Inject

class LawListsUseCase @Inject constructor(
    private val lawListsRepository: LawListsRepository
) {
    suspend operator fun invoke() : LawListsResponse {
        return lawListsRepository.lawLists()
    }
}