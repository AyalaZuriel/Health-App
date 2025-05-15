package com.example.healthapp.domain.usecase

import com.example.healthapp.data.remote.models.WeatherData
import com.example.healthapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchWeatherUseCase @Inject constructor(private val weatherRepository: WeatherRepository) {
    suspend operator fun invoke(latitude: Double, longitude: Double): WeatherData {
        return weatherRepository.fetchWeather(latitude, longitude)
    }

    fun getWeatherData(): Flow<WeatherData> {
        return weatherRepository.getWeatherData()
    }
}
