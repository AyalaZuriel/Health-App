package com.example.healthapp.weather

import androidx.room.Dao
import androidx.room.Query

@Dao
interface WeatherDao {
    @Query("SELECT * FROM weather_table")
    fun getAllWeathers(): Int /*TODO*/
}