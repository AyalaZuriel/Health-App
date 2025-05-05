package com.example.healthapp.weather

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_table")
data class WeatherEntity (
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val city: String,
    val temperature: Double,
    val description: String,
    val timestamp: Long
)