package com.example.congress.domain.usecase

import com.example.congress.data.model.MemberSignInRequest
import com.example.congress.domain.repository.MemberUpdateRepository
import javax.inject.Inject

class MemberUpdateUseCase @Inject constructor(
    private val memberUpdateRepository: MemberUpdateRepository
) {
    suspend operator fun invoke(
        memberUpdateRequest: MemberSignInRequest
    ) {
        memberUpdateRepository.memberUpdate(memberUpdateRequest)
    }
}