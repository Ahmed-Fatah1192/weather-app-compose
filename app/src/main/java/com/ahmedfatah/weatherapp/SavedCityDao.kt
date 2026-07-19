package com.ahmedfatah.weatherapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SavedCityDao {
    @Query("SELECT * FROM saved_cities")
    fun getAllCities(): Flow<List<SavedCity>>

    @Insert
    suspend fun insertCity(city: SavedCity)

    @Update
    suspend fun updateCity(city: SavedCity)

    @Delete
    suspend fun deleteCity(city: SavedCity)
}