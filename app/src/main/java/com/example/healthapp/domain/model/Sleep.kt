package com.example.healthapp.domain.model

import java.time.LocalDate

data class Sleep (
    val id: Long = 0,
    val date: LocalDate,
    val hours: Double
)
