package com.example.weatherapp.data.repository

import com.example.weatherapp.data.remote.model.response.WeatherResponse
import com.example.weatherapp.domain.repository.remote.weatherRepository
import kotlinx.coroutines.flow.flow

class TestRepository : weatherRepository {

    private val weather= mutableListOf<WeatherResponse>()

    override suspend fun getWeather(lat: Double, lon: Double, id: String): WeatherResponse {
        return weather.firstOrNull() ?: throw NoSuchElementException("No weather data available")
    }

    fun addweather(weatherResponse: WeatherResponse){
        weather.add(weatherResponse)
    }
}