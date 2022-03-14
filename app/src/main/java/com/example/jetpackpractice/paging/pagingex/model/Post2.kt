package com.example.jetpackpractice.paging.pagingex.model

import com.google.gson.annotations.SerializedName

data class Post2(
    @SerializedName("userId")
    val myUserId : Int,
    val id : Int,
    val title : String,
    val body : String
)
