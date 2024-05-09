package com.example.weatherapp.data.repository.local

import androidx.lifecycle.LiveData
import com.example.weatherapp.data.local.dao.LoginDao
import com.example.weatherapp.data.local.model.User
import com.example.weatherapp.domain.repository.local.LoginRepository
import javax.inject.Inject
import kotlin.math.log

class loginRepositoryImpl @Inject constructor(private val loginDao: LoginDao):LoginRepository {

    override suspend fun insertUser(user: User) {
        return loginDao.insertUser(user)
    }

    override suspend fun Login(email: String, password: String): User {
       return loginDao.Login(email,password)
    }


}