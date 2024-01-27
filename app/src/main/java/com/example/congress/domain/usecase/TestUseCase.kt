package com.example.congress.domain.usecase

import com.example.congress.domain.repository.TestRepository
import javax.inject.Inject

class TestUseCase @Inject constructor(
    private val testRepository: TestRepository
) {
    suspend operator fun invoke() {
        testRepository.test()
    }
}