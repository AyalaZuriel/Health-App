package com.example.healthapp.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.healthapp.data.local.database.dao.StepDao
import com.example.healthapp.data.local.database.mappers.toEntity
import com.example.healthapp.data.local.database.mappers.toStepItem
import com.example.healthapp.domain.model.Step
import com.example.healthapp.domain.repository.StepRepository
import java.time.LocalDate
import javax.inject.Inject

class StepRepositoryImpl @Inject constructor(private val stepDao: StepDao) : StepRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun insertSteps(step: Step) = stepDao.insert(step.toEntity())

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getStepsByDate(date: LocalDate): Step? = stepDao.getStepsByDate(date.toString())?.toStepItem()

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getAllStepsRecords(): List<Step> = stepDao.getAllSteps().map {
        stepEntity -> stepEntity.toStepItem()
    }
}
