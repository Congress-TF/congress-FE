package com.example.congress.presentation.util

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ApplicationClass: Application() {
    companion object{
        var authToken: String = ""
        const val TAG = "ApplicationContext"
    }
}