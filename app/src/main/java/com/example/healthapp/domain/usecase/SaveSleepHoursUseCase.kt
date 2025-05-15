package com.example.healthapp.domain.usecase

import com.example.healthapp.domain.repository.SleepRepository
import javax.inject.Inject

//todo
class SaveSleepHoursUseCase @Inject constructor(private val sleepRepository: SleepRepository) {
}
