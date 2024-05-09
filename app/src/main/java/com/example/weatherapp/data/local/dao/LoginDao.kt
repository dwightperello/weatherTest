package com.example.weatherapp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.weatherapp.data.local.model.User


@Dao
interface LoginDao {

    @Query("SELECT * FROM User WHERE Email = :email and Password = :password")
   suspend fun Login(email:String,password:String): User

    @Insert
    suspend fun insertUser(user: User)
}