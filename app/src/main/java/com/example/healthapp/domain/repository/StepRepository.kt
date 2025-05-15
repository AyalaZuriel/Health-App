package com.example.healthapp.domain.repository

interface StepRepository {
    suspend fun insertSteps(step: Step)

    suspend fun getStepsByDate(date: LocalDate): Step?

    suspend fun getAllStepsRecords(): List<Step>
}
