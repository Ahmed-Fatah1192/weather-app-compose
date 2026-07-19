package com.ahmedfatah.weatherapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun WeatherAppNavGraph(viewModel: WeatherViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(viewModel = viewModel) {
                navController.navigate("cityList") {
                    popUpTo("login") { inclusive = true }
                }
            }
        }
        composable("cityList") {
            CityListScreen(
                viewModel = viewModel,
                onCityClick = { city -> navController.navigate("cityDetail/${city.cityName}") }
            )
        }
        composable(
            "cityDetail/{cityName}",
            arguments = listOf(navArgument("cityName") { type = NavType.StringType })
        ) { backStackEntry ->
            val cityName = backStackEntry.arguments?.getString("cityName") ?: ""
            CityDetailScreen(viewModel = viewModel, cityName = cityName)
        }
    }
}