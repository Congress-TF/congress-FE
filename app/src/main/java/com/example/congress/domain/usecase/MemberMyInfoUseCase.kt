package com.example.congress.domain.usecase

import com.example.congress.data.model.MemberMyInfoResponse
import com.example.congress.domain.repository.MemberMyInfoRepository
import javax.inject.Inject

class MemberMyInfoUseCase @Inject constructor(
    private val memberMyInfoRepository: MemberMyInfoRepository
) {
    suspend operator fun invoke(
        userId: String,
    ) : MemberMyInfoResponse {
        return memberMyInfoRepository.memberMyInfo(userId)
    }
}