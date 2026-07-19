package com.ahmedfatah.weatherapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_cities")
data class SavedCity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val cityName: String,
    val nickname: String = ""
)