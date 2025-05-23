package com.example.healthapp.ui.screens.statistics

import androidx.lifecycle.ViewModel
import com.example.healthapp.data.local.database.entities.SleepEntity
import com.example.healthapp.domain.repository.StepRepository
import com.example.healthapp.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//todo
@HiltViewModel
class StatisticsViewModel @Inject constructor(
    private val stepRepository: StepRepository,
    private val sleepEntity: SleepEntity,
    private val weatherRepository: WeatherRepository
) : ViewModel() {
}
