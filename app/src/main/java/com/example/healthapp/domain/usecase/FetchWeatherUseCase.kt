package com.example.healthapp.domain.usecase

import com.example.healthapp.domain.repository.WeatherRepository
import javax.inject.Inject

class FetchWeatherUseCase @Inject constructor(private val weatherRepository: WeatherRepository) {
}