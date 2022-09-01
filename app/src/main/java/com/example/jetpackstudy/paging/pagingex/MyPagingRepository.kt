package com.example.jetpackstudy.paging.pagingex

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.jetpackstudy.paging.pagingex.api.RetrofitInstance

class MyPagingRepository {
    fun getPost(userId : Int) =
        Pager(
            config = PagingConfig(
                pageSize = 5,
                maxSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {MyPagingSource(RetrofitInstance.api,userId)}
        ).liveData
}