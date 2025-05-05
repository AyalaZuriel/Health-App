package com.example.healthapp.data.local.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sleep_table")
data class SleepEntity (
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val date: Long,
    val hours: Double
)