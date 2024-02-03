package com.example.congress.data.module

import com.example.congress.data.network.ApiService
import com.example.congress.data.repository.HashtagRankRepositoryImpl
import com.example.congress.data.repository.HashtagSaveRepositoryImpl
import com.example.congress.data.repository.LawDetailRepositoryImpl
import com.example.congress.data.repository.LawLegislatorRepositoryImpl
import com.example.congress.data.repository.LawListsRepositoryImpl
import com.example.congress.data.repository.LawVoteRepositoryImpl
import com.example.congress.data.repository.MemberCheckRepositoryImpl
import com.example.congress.data.repository.MemberMyInfoRepositoryImpl
import com.example.congress.data.repository.MemberSignInRepositoryImpl
import com.example.congress.data.repository.MemberSignOutRepositoryImpl
import com.example.congress.data.repository.MemberUpdateRepositoryImpl
import com.example.congress.data.repository.VoteRepositoryImpl
import com.example.congress.data.repository.VoteTotalRepositoryImpl
import com.example.congress.data.utils.AppInterceptor
import com.example.congress.domain.repository.HashtagRankRepository
import com.example.congress.domain.repository.HashtagSaveRepository
import com.example.congress.domain.repository.LawDetailRepository
import com.example.congress.domain.repository.LawLegislatorRepository
import com.example.congress.domain.repository.LawListsRepository
import com.example.congress.domain.repository.LawVoteRepository
import com.example.congress.domain.repository.MemberCheckRepository
import com.example.congress.domain.repository.MemberMyInfoRepository
import com.example.congress.domain.repository.MemberSignInRepository
import com.example.congress.domain.repository.MemberSignOutRepository
import com.example.congress.domain.repository.MemberUpdateRepository
import com.example.congress.domain.repository.VoteRepository
import com.example.congress.domain.repository.VoteTotalRepository
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
    private val BASE_URL = "https://congresstf.link"

    @Singleton
    @Provides
    fun provideInterceptor(): AppInterceptor {
        return AppInterceptor()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(interceptor: AppInterceptor): OkHttpClient {
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

        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()
    }


    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideMemberSignInRepository(apiService: ApiService): MemberSignInRepository {
        return MemberSignInRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideMemberSignOutRepository(apiService: ApiService): MemberSignOutRepository {
        return MemberSignOutRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideMemberCheckRepository(apiService: ApiService) : MemberCheckRepository {
        return MemberCheckRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideMemberMyInfoRepository(apiService: ApiService) : MemberMyInfoRepository {
        return MemberMyInfoRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideMemberUpdateRepository(apiService: ApiService) : MemberUpdateRepository {
        return MemberUpdateRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideHashtagSaveRepository(apiService: ApiService): HashtagSaveRepository {
        return HashtagSaveRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideHashtagRankRepository(apiService: ApiService) : HashtagRankRepository {
        return HashtagRankRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideVoteRepository(apiService: ApiService): VoteRepository {
        return VoteRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideVoteTotalRepository(apiService: ApiService): VoteTotalRepository {
        return VoteTotalRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideLawVoteRepository(apiService: ApiService): LawVoteRepository {
        return LawVoteRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideLawDetailRepository(apiService: ApiService): LawDetailRepository {
        return LawDetailRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideLawListsRepository(apiService: ApiService): LawListsRepository {
        return LawListsRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideLawLegislatorRepository(apiService: ApiService): LawLegislatorRepository {
        return LawLegislatorRepositoryImpl(apiService)
    }
}
