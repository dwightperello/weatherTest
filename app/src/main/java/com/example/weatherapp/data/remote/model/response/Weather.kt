package com.example.weatherapp.data.remote.model.response

data class Weather(
    val id: Int,
    val main: String,
    val description:
    String, val icon: String
)