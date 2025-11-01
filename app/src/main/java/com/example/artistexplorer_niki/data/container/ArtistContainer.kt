package com.example.artistexplorer_niki.data.container

import com.example.artistexplorer_niki.data.service.MusicService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://theaudiodb.com/api/v1/json/123/"

    val api: MusicService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MusicService::class.java)
    }
}