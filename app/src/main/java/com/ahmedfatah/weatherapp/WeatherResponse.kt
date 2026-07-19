package com.ahmedfatah.weatherapp

data class WeatherResponse(
    val name: String,
    val main: MainInfo,
    val weather: List<WeatherDetail>
)

data class MainInfo(
    val temp: Double,
    val humidity: Int
)

data class WeatherDetail(
    val description: String,
    val icon: String
)