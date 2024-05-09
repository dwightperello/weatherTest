package com.example.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.getOrAwaitValue
import com.example.weatherapp.data.local.AppDatabase
import com.example.weatherapp.data.local.dao.LoginDao
import com.example.weatherapp.data.local.model.User
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
class LoginDaoTest {

    @get:Rule
    var instantTaskExecutorRule= InstantTaskExecutorRule()
    private lateinit var database:AppDatabase
    private lateinit var dao:LoginDao

    @Before
    fun setup(){
        database= Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
        dao=database.provideLoginDao()
    }

    @After
    fun tearDown(){
        database.close()
    }

    @Test
    fun register()= runTest {
        val user= User(
            Id = 1,
            Email = "test@test.com",
            Name = "test",
            Password = "pass12345",
            Address = "test address"
        )
        dao.insertUser(user)
        val userinfo = dao.Login("test@test.com","pass12345").getOrAwaitValue()
        assertThat(userinfo.Id).isEqualTo(user.Id)
        assertThat(userinfo.Email).isEqualTo(user.Email)
        assertThat(userinfo.Name).isEqualTo(user.Name)
        assertThat(userinfo.Password).isEqualTo(user.Password)
        assertThat(userinfo.Address).isEqualTo(user.Address)
    }

}