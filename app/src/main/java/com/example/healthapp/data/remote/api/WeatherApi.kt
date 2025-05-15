package com.example.healthapp.data.remote.api

import com.example.healthapp.data.remote.models.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

// https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid=f1b3e4d0f9d401ded19c4b73497870e6

interface WeatherApi {
    @GET("weather")
    suspend fun getWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") apiKey: String = "f1b3e4d0f9d401ded19c4b73497870e6"
    ): WeatherResponse
}
