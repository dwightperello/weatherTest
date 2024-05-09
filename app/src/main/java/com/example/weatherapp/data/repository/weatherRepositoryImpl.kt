package com.example.weatherapp.data.repository

import com.example.weatherapp.data.remote.response.WeatherResponse
import com.example.weatherapp.data.remote.weatherAPI
import com.example.weatherapp.domain.repository.weatherRepository
import kotlinx.coroutines.flow.Flow

class weatherRepositoryImpl(private val weatherAPI: weatherAPI):weatherRepository {

    override suspend fun getWeather(lat: Double, lon: Double, id: String): WeatherResponse {
        return weatherAPI.getWeather(lat,lon,id)
    }
}