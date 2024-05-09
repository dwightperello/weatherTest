package com.example.weatherapp.domain.usecase.local.weather

import com.example.weatherapp.data.local.model.weather
import com.example.weatherapp.domain.repository.local.weatherRepositoryLocal
import com.example.weatherapp.util.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class getAllWeatherUseCase @Inject constructor(private val weatherRepositoryLocal: weatherRepositoryLocal) {
    operator fun invoke():Flow<ResultState<List<weather>>> = flow {
        emit(ResultState.Loading())
        try {
            val weather= weatherRepositoryLocal.getAllWethers()
            emit(ResultState.Success<List<weather>>(weather))
        }catch (e:Exception){
            emit(ResultState.Error<List<weather>>(e.localizedMessage ?: "error on getting weathers"))
        }
    }
}