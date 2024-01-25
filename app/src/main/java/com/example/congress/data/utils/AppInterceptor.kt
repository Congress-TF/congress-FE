package com.example.congress.data.utils

import com.example.congress.presentation.util.ApplicationClass
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class AppInterceptor: Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val authToken = ApplicationClass.authToken
        val request = chain.request().newBuilder()
            .addHeader("Authorization", authToken)
            .build()
        return chain.proceed(request)
    }
}