package com.example.weatherapp.data.repository.remote

import com.example.weatherapp.data.remote.model.response.WeatherResponse
import com.example.weatherapp.data.remote.weatherAPI
import com.example.weatherapp.domain.repository.remote.weatherRepository

class weatherRepositoryImpl(private val weatherAPI: weatherAPI): weatherRepository {

    override suspend fun getWeather(lat: Double, lon: Double, id: String): WeatherResponse {
        return weatherAPI.getWeather(lat,lon,id)
    }
}