package com.example.healthapp.weather

import com.example.healthapp.domain.model.Weather
import java.util.Date

fun Weather.toEntity(): WeatherEntity {
    return WeatherEntity(
        id = this.id,
        city = this.city,
        temperature = this.temperature,
        description = this.description,
        timestamp = timestamp.time
    )
}

fun WeatherEntity.toSleepItem(): Weather {
    return Weather(
        id = this.id,
        city = this.city,
        temperature = this.temperature,
        description = this.description,
        timestamp = Date(timestamp)
    )
}