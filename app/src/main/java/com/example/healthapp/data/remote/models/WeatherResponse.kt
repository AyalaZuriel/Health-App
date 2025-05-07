package com.example.healthapp.data.remote.models

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("weather")
    val weather: List<Weather>,
    @SerializedName("main")
    val main: Main,
    @SerializedName("cityName")
    val name: String
)

data class Weather(
    @SerializedName("description")
    val description: String
)

data class Main(
    @SerializedName("temperature")
    val temp: Double
)