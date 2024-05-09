package com.example.weatherapp.data.remote

import com.example.weatherapp.data.remote.model.response.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface weatherAPI {

   @GET("weather")
   suspend fun getWeather(
       @Query("lat") lat:Double,
       @Query("lon") lon :Double,
       @Query("appid")id:String
   ): WeatherResponse
}