package com.example.congress.domain.usecase

import com.example.congress.data.model.MemberSignInRequest
import com.example.congress.domain.repository.LoginRepository
import javax.inject.Inject

class MemberSignInUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    suspend operator fun invoke(
        memberSignInRequest: MemberSignInRequest
    ) {
        return loginRepository.userLogin(memberSignInRequest)
    }
}