package com.example.healthapp.domain.usecase

import com.example.healthapp.domain.repository.StepRepository
import javax.inject.Inject

class FetchStepsUseCase @Inject constructor(private val stepRepository: StepRepository) {
}