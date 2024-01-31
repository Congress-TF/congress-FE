package com.example.congress.domain.usecase

import com.example.congress.domain.repository.MemberSignOutRepository
import javax.inject.Inject

class MemberSignOutUseCase @Inject constructor(
    private val memberSignOutRepository: MemberSignOutRepository
) {
    suspend operator fun invoke(
        sampleUserId: String
    ) {
        memberSignOutRepository.memberSignOut(sampleUserId)
    }
}