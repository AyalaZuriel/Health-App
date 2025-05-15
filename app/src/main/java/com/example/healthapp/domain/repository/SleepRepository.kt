package com.example.healthapp.domain.repository

interface SleepRepository {
    suspend fun insertSleep(sleep: Sleep)

    suspend fun getSleepByDate(date: LocalDate): Sleep?

    suspend fun getAllSleepRecords(): List<Sleep>
}
