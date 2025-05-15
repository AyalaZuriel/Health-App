package com.example.healthapp.domain.model

import java.util.Date

data class Weather (
    val id: Long = 0,
    val city: String,
    val temperature: Double,
    val description: String,
    val timestamp: Date
)
