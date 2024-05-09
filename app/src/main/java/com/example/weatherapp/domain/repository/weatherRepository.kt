package com.example.weatherapp.domain.repository

import com.example.weatherapp.data.remote.response.WeatherResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query

interface weatherRepository {

    suspend fun getWeather(
       lat:Double,
       lon :Double,
       id:String
    ):WeatherResponse
}