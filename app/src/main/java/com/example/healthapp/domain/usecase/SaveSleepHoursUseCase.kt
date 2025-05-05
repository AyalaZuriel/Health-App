package com.example.healthapp.domain.usecase

import com.example.healthapp.domain.repository.SleepRepository
import javax.inject.Inject

class SaveSleepHoursUseCase @Inject constructor(private val sleepRepository: SleepRepository) {
}