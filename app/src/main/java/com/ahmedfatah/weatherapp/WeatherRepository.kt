package com.ahmedfatah.weatherapp

import kotlinx.coroutines.flow.Flow

class WeatherRepository(private val dao: SavedCityDao, private val apiKey: String) {

    val savedCities: Flow<List<SavedCity>> = dao.getAllCities()

    suspend fun fetchWeather(cityName: String): WeatherResponse {
        return RetrofitInstance.api.getCurrentWeather(cityName, apiKey)
    }

    suspend fun addCity(cityName: String) {
        dao.insertCity(SavedCity(cityName = cityName))
    }

    suspend fun renameCity(city: SavedCity, newNickname: String) {
        dao.updateCity(city.copy(nickname = newNickname))
    }

    suspend fun removeCity(city: SavedCity) {
        dao.deleteCity(city)
    }
}