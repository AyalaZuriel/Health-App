package com.example.healthapp.domain.model

import java.time.LocalDate

data class Step (
    val id: Long = 0,
    val date: LocalDate,
    val stepCount: Int
)
