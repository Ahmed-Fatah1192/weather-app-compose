package com.ahmedfatah.weatherapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CityDetailScreen(viewModel: WeatherViewModel, cityName: String) {
    LaunchedEffect(cityName) {
        viewModel.loadWeather(cityName)
    }

    val weather = viewModel.weatherResult
    val error = viewModel.errorMessage

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(cityName, fontSize = 24.sp)
        Spacer(Modifier.height(16.dp))

        when {
            error != null -> Text(error, color = Color.Red)
            weather == null -> CircularProgressIndicator()
            else -> {
                Text("${weather.main.temp}°C", fontSize = 40.sp)
                Text(weather.weather.firstOrNull()?.description ?: "")
                Spacer(Modifier.height(8.dp))
                Text("Humidity: ${weather.main.humidity}%")
            }
        }
    }
}