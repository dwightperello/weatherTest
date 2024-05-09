package com.example.weatherapp.domain.usecase.remote

import com.example.weatherapp.data.local.model.weather
import com.example.weatherapp.data.remote.model.response.WeatherResponse
import com.example.weatherapp.domain.repository.remote.weatherRepository
import com.example.weatherapp.util.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class getWeatherUsecase @Inject constructor(private val weatherRepository: weatherRepository ) {
    operator fun invoke( lat:Double,lon :Double, id:String):Flow<ResultState<WeatherResponse>> = flow {
        emit(ResultState.Loading())
        try {
            val weather= weatherRepository.getWeather(lat,lon,id)
            emit(ResultState.Success<WeatherResponse>(weather))
        }catch (e:Exception){
           emit(ResultState.Error<WeatherResponse>(e.localizedMessage ?: "error on getting weather"))
        }
    }


}