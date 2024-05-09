package com.example.weatherapp.domain.usecase.local.Login

import com.example.weatherapp.data.local.model.User
import com.example.weatherapp.domain.repository.local.LoginRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val loginRepository: LoginRepository) {

   suspend operator fun invoke(user: User){
        return loginRepository.insertUser(user)
    }
}