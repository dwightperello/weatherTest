package com.example.weatherapp.domain.usecase.local.weather

data class WeatherUseCases(
    val insertWeather:insertWeatherUseCase,
    val getAllWeather:getAllWeatherUseCase
)
