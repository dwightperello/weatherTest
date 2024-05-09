package com.example.weatherapp.domain.usecase.local.weather

import com.example.weatherapp.data.local.model.weather
import com.example.weatherapp.domain.repository.local.weatherRepositoryLocal
import javax.inject.Inject

class insertWeatherUseCase @Inject constructor(private val weatherRepositoryLocal: weatherRepositoryLocal) {

    suspend operator fun invoke(weather: weather){
        return weatherRepositoryLocal.insertWeather(weather)
    }
}