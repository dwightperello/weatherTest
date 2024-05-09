package com.example.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.getOrAwaitValue
import com.example.weatherapp.data.local.AppDatabase
import com.example.weatherapp.data.local.dao.LoginDao
import com.example.weatherapp.data.local.dao.weatherDao
import com.example.weatherapp.data.local.model.User
import com.example.weatherapp.data.local.model.weather
import com.google.common.truth.Truth
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class weaterhDaoTest {

    @get:Rule
    var instantTaskExecutorRule= InstantTaskExecutorRule()
    private lateinit var database: AppDatabase
    private lateinit var dao: weatherDao

    @Before
    fun setup(){
        database= Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
        dao=database.provideWeatherDao()
    }

    @After
    fun tearDown(){
        database.close()
    }

    @Test
    fun weather()= runTest {
        val wet= weather(
            Id = 1,
            temp = 37.0,
            datestemp = "may 9",
            description = "super hot",
            sunrise = 1715203813,
            sunset =1715249672

        )
        dao.InsertWeather(wet)
        val userinfo = dao.getAllWeather()
        assertThat(userinfo).contains(wet)
    }

}