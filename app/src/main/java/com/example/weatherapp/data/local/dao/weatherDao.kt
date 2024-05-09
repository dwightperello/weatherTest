package com.example.weatherapp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.weatherapp.data.local.model.weather

@Dao
interface weatherDao {

    @Insert
    suspend fun InsertWeather(weather: weather)

    @Query("SELECT * FROM weather")
    fun getAllWeather():LiveData<List<weather>>
}