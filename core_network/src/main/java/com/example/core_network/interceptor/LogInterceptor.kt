package com.example.core_network.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class LogInterceptor @Inject constructor() :Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        Logger.info(response.code().toString())
        return response
    }
}
class Logger{
    companion object{
        const val TAG = "Logger"
        fun info(message:String){
            Log.i(TAG,message)
        }
    }
}