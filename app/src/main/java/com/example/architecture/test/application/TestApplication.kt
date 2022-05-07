package com.example.architecture.test.application

import android.app.Application
import com.salem.onebible.app.networking.RemoteApi
import com.salem.onebible.app.networking.buildApiService

class TestApplication: Application(){

    companion object{
        private lateinit var instance : TestApplication

        private val apiService by lazy {  buildApiService() }

        val remoteApi by lazy {RemoteApi(apiService)}

    }

}