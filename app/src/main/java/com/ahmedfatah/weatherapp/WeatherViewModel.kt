package com.ahmedfatah.weatherapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

    val savedCities: StateFlow<List<SavedCity>> = repository.savedCities
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    var isLoggedIn by mutableStateOf(false)
        private set

    var weatherResult by mutableStateOf<WeatherResponse?>(null)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun login(username: String, password: String): Boolean {
        val success = username.isNotBlank() && password.length >= 4
        isLoggedIn = success
        return success
    }

    fun loadWeather(cityName: String) {
        viewModelScope.launch {
            try {
                errorMessage = null
                weatherResult = repository.fetchWeather(cityName)
            } catch (e: Exception) {
                errorMessage = "Couldn't find weather for \"$cityName\". Check the spelling and try again."
            }
        }
    }

    fun addCity(cityName: String) {
        viewModelScope.launch {
            repository.addCity(cityName)
        }
    }

    fun removeCity(city: SavedCity) {
        viewModelScope.launch {
            repository.removeCity(city)
        }
    }
}