package com.codetutor.simplenavigationexample

import android.app.Application
import com.codetutor.simplenavigationexample.data.AppRepository

class MyApplication: Application() {
    private var repository : AppRepository? = null

    override fun onCreate() {
        super.onCreate()
        repository = AppRepository()
    }

    fun getRepository(): AppRepository? {
        return repository
    }
}