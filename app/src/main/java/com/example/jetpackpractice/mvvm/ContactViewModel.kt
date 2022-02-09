package com.example.jetpackpractice.mvvm

import android.app.Application
import androidx.lifecycle.*
import com.example.jetpackpractice.mvvm.room.Contact

 class ContactViewModel(application: Application) : ViewModel(){

    private val repository = ContactRepository(application)

    fun getAll(): LiveData<List<Contact>> {
        return repository.getAll()
    }

    fun insert(contact: Contact){
        repository.insert(contact)
    }

    fun delete(contact: Contact){
        repository.delete(contact)
    }

     override fun onCleared() {
         super.onCleared()
     }
}