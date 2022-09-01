package com.example.jetpackstudy.paging.pagingex

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.jetpackstudy.paging.pagingex.api.TestApi
import com.example.jetpackstudy.paging.pagingex.model.Post2
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_IDX = 1

class MyPagingSource(
    private val testApi : TestApi,
    private val userId : Int) : PagingSource<Int, Post2>() {
    override fun getRefreshKey(state: PagingState<Int, Post2>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Post2> {
        return try {
            val position = params.key?: STARTING_PAGE_IDX
            val response = testApi.getCustomPost2(
                userId = userId,
                sort = "id",
                order = "asc"
            )

            val post = response.body()

            LoadResult.Page(
                data = post!!,
                prevKey = if(position== STARTING_PAGE_IDX) null else position-1,
                nextKey = position + 1
            )
        } catch (exception : IOException){
            LoadResult.Error(exception)
        } catch (exception : HttpException){
            LoadResult.Error(exception)
        }
    }

}