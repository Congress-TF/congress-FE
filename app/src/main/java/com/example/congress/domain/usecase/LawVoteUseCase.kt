package com.example.congress.domain.usecase

import com.example.congress.domain.repository.LawVoteRepository
import javax.inject.Inject

class LawVoteUseCase @Inject constructor(
    private val lawVoteRepository: LawVoteRepository
) {
    suspend operator fun invoke(
        userId: String,
        lawName: String,
    ) {
        lawVoteRepository.lawVote(userId, lawName)
    }
}