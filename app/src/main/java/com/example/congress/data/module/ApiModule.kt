package com.example.congress.data.module

import com.example.congress.data.network.ApiService
import com.example.congress.data.utils.AppInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {
    private val BASE_URL = "BASE_URL"

    @Singleton
    @Provides
    fun provideInterceptor(): AppInterceptor{
        return AppInterceptor()
    }

    @Singleton
    @Provides
    fun provideOkHttpBuilder(
        interceptor: AppInterceptor
    ): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addNetworkInterceptor(httpLoggingInterceptor)
            .connectTimeout(40, TimeUnit.SECONDS)
            .readTimeout(40, TimeUnit.SECONDS)
            .writeTimeout(40, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder().client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(provideOkHttpBuilder(provideInterceptor()))
            .baseUrl(BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}