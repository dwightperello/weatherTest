package com.example.weatherapp.domain.repository.local

import androidx.lifecycle.LiveData
import com.example.weatherapp.data.local.model.User

interface LoginRepository {
   suspend fun insertUser(user: User)
   suspend fun Login(email:String,password:String):User

}