package com.example.jetpackpractice.paging.pagingex.api

import com.example.jetpackpractice.paging.pagingex.model.Post2
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TestApi {
    @GET("posts")
    suspend fun getCustomPost2(
        @Query("userId") userId:Int,
        @Query("_sort") sort : String,
        @Query("_order") order : String
    ): Response<List<Post2>>
}