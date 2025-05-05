package com.example.healthapp.data.local.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "steps_table")
data class StepEntity (
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val date: Long,
    val stepCount: Int
)
