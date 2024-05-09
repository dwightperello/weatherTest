package com.example.weatherapp.domain.repository.local

import com.example.weatherapp.data.local.model.User
import com.example.weatherapp.data.local.model.weather


interface weatherRepositoryLocal {
    suspend fun insertWeather(weather:weather)
    suspend fun getAllWethers():List<weather>
}