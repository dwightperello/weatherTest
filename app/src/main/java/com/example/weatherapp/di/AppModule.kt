package com.example.weatherapp.di

import android.app.Application
import android.content.Context
import com.example.weatherapp.data.local.AppDatabase
import com.example.weatherapp.data.local.dao.LoginDao
import com.example.weatherapp.data.local.dao.weatherDao
import com.example.weatherapp.data.remote.weatherAPI
import com.example.weatherapp.data.repository.weatherRepositoryImpl
import com.example.weatherapp.domain.repository.weatherRepository
import com.example.weatherapp.util.constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Application):AppDatabase{
        return AppDatabase.getAppDB(context)
    }

    @Provides
    @Singleton
    fun provideLoginDao(appDatabase: AppDatabase):LoginDao = appDatabase.provideLoginDao()


    @Provides
    @Singleton
    fun provideWeatherDao(appDatabase: AppDatabase):weatherDao = appDatabase.provideWeatherDao()

    @Provides
    @Singleton
    fun provideAPI():Retrofit{
        return Retrofit.Builder()
            .baseUrl(constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    inline fun <reified T>provideAPIcalls(retrofit: Retrofit):T{
        return retrofit.create(T::class.java)
    }

    @Provides
    @Singleton
    fun provideAPIcalls(retrofit: Retrofit):weatherAPI{
        return provideAPIcalls(retrofit)
    }

    @Provides
    @Singleton
    fun provideAPIrepository(weatherAPI: weatherAPI): weatherRepository = weatherRepositoryImpl(weatherAPI)
}