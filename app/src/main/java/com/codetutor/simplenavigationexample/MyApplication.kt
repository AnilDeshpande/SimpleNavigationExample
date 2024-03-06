package com.codetutor.simplenavigationexample

import android.app.Application
import com.codetutor.simplenavigationexample.data.AppRepository

class MyApplication : Application() {
    private lateinit var repository: AppRepository

    override fun onCreate() {
        super.onCreate()
        repository = AppRepository()
    }

    fun getRepository(): AppRepository {
        return repository
    }
}