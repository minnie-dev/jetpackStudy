package com.example.jetpackstudy.paging.pagingex.api

import com.example.jetpackstudy.paging.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api : TestApi by lazy {
        retrofit.create(TestApi::class.java)
    }
}