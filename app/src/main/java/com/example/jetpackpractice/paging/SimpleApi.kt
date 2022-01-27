package com.example.jetpackpractice.paging

import retrofit2.http.GET

interface SimpleApi {
    @GET("posts/1")
    suspend fun getPost():Post
}