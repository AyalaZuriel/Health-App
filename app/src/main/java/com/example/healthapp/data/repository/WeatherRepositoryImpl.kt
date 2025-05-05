package com.example.healthapp.data.repository

import com.example.healthapp.domain.model.UserSetting
import com.example.healthapp.weather.WeatherDao
import com.example.healthapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val dataStore: DataStore<UserSetting>) : WeatherRepository {
    suspend fun updateSettings(update: (UserSetting) -> UserSetting) {
        dataStore.updateData(update)
    }

    fun getSettings(): Flow<UserSetting> = dataStore.data
}