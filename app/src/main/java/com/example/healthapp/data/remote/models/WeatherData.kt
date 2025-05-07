package com.example.healthapp.data.remote.models

data class WeatherData(
    val temperature: Double,
    val description: String,
    val cityName: String,
    val lastUpdated: Long = System.currentTimeMillis()
)