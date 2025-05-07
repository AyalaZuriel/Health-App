package com.example.healthapp.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.healthapp.data.remote.api.WeatherApi
import com.example.healthapp.data.remote.models.WeatherData
import com.example.healthapp.domain.model.UserSetting
import com.example.healthapp.domain.repository.WeatherRepository
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "weather_data")

class WeatherRepositoryImpl @Inject constructor(
    private val context: Context,
    private val weatherApi: WeatherApi,
    private val gson: Gson
) : WeatherRepository {

    private object PreferencesKeys {
        val WEATHER_DATA = stringPreferencesKey("weather_data")
    }

    override suspend fun fetchWeather(latitude: Double, longitude: Double): WeatherData {
        val response = weatherApi.getWeather(latitude, longitude)
        val weatherData = WeatherData(
            temperature = response.main.temperature,
            description = response.weather.firstOrNull()?.description ?: "",
            cityName = response.cityName
        )
        updateWeatherData(weatherData)
        return weatherData
    }

    override fun getWeatherData(): Flow<WeatherData> {
        return context.dataStore.data.map { preferences ->
            val weatherDataJson = preferences[PreferencesKeys.WEATHER_DATA]
            if (weatherDataJson.isNullOrEmpty()) {
                WeatherData(
                    temperature = 0.0,
                    description = "",
                    cityName = ""
                )
            } else {
                try {
                    gson.fromJson(weatherDataJson, WeatherData::class.java)
                } catch (e: Exception) {
                    WeatherData(
                        temperature = 0.0,
                        description = "",
                        cityName = ""
                    )
                }
            }
        }
    }

    override suspend fun updateWeatherData(weatherData: WeatherData) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.WEATHER_DATA] = gson.toJson(weatherData)
        }
    }

    suspend fun updateSettings(update: (UserSetting) -> UserSetting) {
        // Implementation needed
    }

    fun getSettings(): Flow<UserSetting> {
        // Implementation needed
        throw UnsupportedOperationException("Method not implemented")
    }
}