package com.example.jetpackpractice.paging

class Repository {
    suspend fun getPost():Post{
        return RetrofitInstance.api.getPost()
    }
}