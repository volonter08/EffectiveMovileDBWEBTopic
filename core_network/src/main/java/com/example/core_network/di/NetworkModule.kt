package com.example.core_network.di

import com.example.core_network.GoogleApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module
class NetworkModule {
    @Provides
    fun provideOkHttpClient(logInterceptor: com.example.core_network.interceptor.LogInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(logInterceptor).build()
    }
    @Provides
    fun provideRetrofit(client: OkHttpClient):Retrofit{
        return Retrofit.Builder().baseUrl("https://httpbin.org/").client(client).build()
    }
    @Provides
    fun provideGoggleApiService(retrofit: Retrofit):GoogleApiService{
        return retrofit.create(GoogleApiService::class.java)
    }
}