package com.example.weatherapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.weatherapp.data.local.dao.LoginDao
import com.example.weatherapp.data.local.dao.weatherDao
import com.example.weatherapp.data.local.model.User
import com.example.weatherapp.data.local.model.weather

@Database(entities = [User::class,weather::class],version = 1)
abstract class AppDatabase :RoomDatabase() {

    abstract fun provideLoginDao(): LoginDao
    abstract fun provideWeatherDao():weatherDao

    companion object{
        private  var dbInstance:AppDatabase?= null
        fun getAppDB(context: Context):AppDatabase{
            if(dbInstance==null){
                dbInstance= Room.databaseBuilder<AppDatabase>(
                    context.applicationContext,AppDatabase::class.java,"WeatherDB"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return dbInstance!!
        }
    }
}