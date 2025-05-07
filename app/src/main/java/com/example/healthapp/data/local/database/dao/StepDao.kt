package com.example.healthapp.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.healthapp.data.local.database.entities.StepEntity

@Dao
interface StepDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(stepEntity: StepEntity)

    @Query("SELECT * FROM steps_table WHERE date = :date")
    suspend fun getStepsByDate(date: String): StepEntity?

    @Query("SELECT * FROM steps_table")
    suspend fun getAllSteps(): List<StepEntity>
}