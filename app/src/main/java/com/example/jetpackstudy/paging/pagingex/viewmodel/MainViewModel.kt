package com.example.jetpackstudy.paging.pagingex.viewmodel

import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.example.jetpackstudy.paging.pagingex.MyPagingRepository

class MainViewModel (private val repository: MyPagingRepository) : ViewModel() {
    private val myCustomPost2 : MutableLiveData<Int> = MutableLiveData()

    val result = myCustomPost2.switchMap { queryString ->
        repository.getPost(queryString).cachedIn(viewModelScope)
    }

    fun searchPost(userId:Int){
        myCustomPost2.value = userId
    }
}

class MainViewModelFactory(private val repository: MyPagingRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }

}