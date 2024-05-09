package com.example.weatherapp.domain.usecase.local.Login

import androidx.lifecycle.LiveData
import com.example.weatherapp.data.local.model.User
import com.example.weatherapp.domain.repository.local.LoginRepository
import com.example.weatherapp.util.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val loginRepository: LoginRepository) {
    operator fun invoke(email:String,password:String): Flow<ResultState<User>> = flow {
        emit(ResultState.Loading())
        try {
            val user= loginRepository.Login(email,password)
            emit(ResultState.Success<User>(user))
        }catch (e:Exception){
            emit(ResultState.Error<User>(e.localizedMessage ?: "error on login"))
        }
    }
}