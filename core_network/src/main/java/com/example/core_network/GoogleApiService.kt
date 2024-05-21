package com.example.core_network

import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.http.GET

interface GoogleApiService {
    @GET("get")
    suspend fun get():ResponseBody
}