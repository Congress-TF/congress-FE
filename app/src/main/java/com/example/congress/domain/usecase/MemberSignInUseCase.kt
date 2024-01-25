package com.example.congress.domain.usecase

import com.example.congress.data.model.MemberSignInRequest
import com.example.congress.domain.repository.MemberSignInRepository
import javax.inject.Inject

class MemberSignInUseCase @Inject constructor(
    private val memberSignInRepository: MemberSignInRepository
) {
    suspend operator fun invoke(
        memberSignInRequest: MemberSignInRequest
    ) {
        memberSignInRepository.memberSignIn(memberSignInRequest)
    }
}