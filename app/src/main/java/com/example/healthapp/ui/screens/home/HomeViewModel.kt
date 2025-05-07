package com.example.healthapp.ui.screens.home

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.healthapp.data.local.database.entities.SleepEntity
import com.example.healthapp.data.remote.models.WeatherData
import com.example.healthapp.domain.repository.StepRepository
import com.example.healthapp.domain.repository.WeatherRepository
import com.google.android.gms.location.FusedLocationProviderClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val stepRepository: StepRepository,
    private val sleepEntity: SleepEntity,
    private val weatherRepository: WeatherRepository,
    private val fusedLocationClient: FusedLocationProviderClient
) : ViewModel() {

    private val _weatherState = MutableLiveData<WeatherData>()
    val weatherState: LiveData<WeatherData> = _weatherState

    private val _errorState = MutableLiveData<String>()
    val errorState: LiveData<String> = _errorState

    init {
        getWeatherData()
    }

    fun getWeatherData() {
        viewModelScope.launch {
            try {
                fusedLocationClient.lastLocation
                    .addOnSuccessListener { location ->
                        location?.let {
                            fetchWeather(it.latitude, it.longitude)
                        } ?: run {
                            _errorState.value = "Location not available"
                        }
                    }
                    .addOnFailureListener {
                        _errorState.value = "Failed to get location: ${it.message}"
                    }
            } catch (e: Exception) {
                _errorState.value = "Error: ${e.message}"
            }
        }
    }

    private fun fetchWeather(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            try {
                val weatherData = weatherRepository.fetchWeather(latitude, longitude)
                _weatherState.value = weatherData
            } catch (e: Exception) {
                _errorState.value = "Failed to fetch weather: ${e.message}"
            }
        }
    }

    // Observe cached weather data
    val cachedWeatherData = weatherRepository.getWeatherData().asLiveData()
}