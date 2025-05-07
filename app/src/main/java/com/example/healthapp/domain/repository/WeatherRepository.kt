package com.example.healthapp.domain.repository

import com.example.healthapp.data.remote.models.WeatherData
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    suspend fun fetchWeather(latitude: Double, longitude: Double): WeatherData

    fun getWeatherData(): Flow<WeatherData>

    suspend fun updateWeatherData(weatherData: WeatherData)
}