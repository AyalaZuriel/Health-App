package com.example.healthapp.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.healthapp.data.local.database.entities.SleepEntity

@Dao
interface SleepDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(sleepEntity: SleepEntity)

    @Query("SELECT * FROM sleep_table WHERE date = :date")
    suspend fun getSleepByDate(date: String): SleepEntity?

    @Query("SELECT * FROM sleep_table")
    suspend fun getAllSleep(): List<SleepEntity>
}
