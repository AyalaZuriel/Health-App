package com.example.healthapp.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.healthapp.data.local.database.dao.SleepDao
import com.example.healthapp.data.local.database.mappers.toEntity
import com.example.healthapp.data.local.database.mappers.toSleepItem
import com.example.healthapp.domain.model.Sleep
import com.example.healthapp.domain.repository.SleepRepository
import java.time.LocalDate
import java.util.Date
import javax.inject.Inject

class SleepRepositoryImpl @Inject constructor(private val sleepDao: SleepDao) : SleepRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun insertSleep(sleep: Sleep) = sleepDao.insert(sleep.toEntity())

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun getSleepByDate(date: LocalDate): Sleep? = sleepDao.getSleepByDate(date.toString())?.toSleepItem()

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun getAllSleepRecords(): List<Sleep> = sleepDao.getAllSleep().map {
        sleepEntity -> sleepEntity.toSleepItem()
    }
}