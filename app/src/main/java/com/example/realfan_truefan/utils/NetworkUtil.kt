package com.example.realfan_truefan.utils

import com.example.realfan_truefan.utils.constants.ApiConfig.BASE_API_URL
import com.google.gson.GsonBuilder
import com.example.realfan_truefan.api.ApiService
import com.example.realfan_truefan.utils.constants.ApiConfig.API_VERSION
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A NetworkUtil Singleton class to initialize our retrofit(HTTP calls) instance
 */
object NetworkUtil {

    private val retrofit: Retrofit

    init {
        val gson = GsonBuilder().setLenient().create()

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_API_URL + API_VERSION)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    private fun getRetrofit(): Retrofit {
        return retrofit
    }

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)

}
