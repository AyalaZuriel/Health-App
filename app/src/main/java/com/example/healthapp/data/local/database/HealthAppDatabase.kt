package com.example.healthapp.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.healthapp.data.local.database.dao.SleepDao
import com.example.healthapp.data.local.database.entities.SleepEntity
import com.example.healthapp.data.local.database.dao.StepDao
import com.example.healthapp.data.local.database.entities.StepEntity

@Database(entities = [StepEntity::class, SleepEntity::class], version = 1, exportSchema = false)
abstract class HealthAppDatabase : RoomDatabase() {
    abstract fun stepDao(): StepDao
    abstract fun sleepDao(): SleepDao

    companion object {
        @Volatile
        private var INSTANCE: HealthAppDatabase? = null

        fun getDatabase(context: Context): HealthAppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HealthAppDatabase::class.java,
                    "health_app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}