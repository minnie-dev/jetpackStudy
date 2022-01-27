package com.example.jetpackpractice.paging

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackpractice.R
import com.example.jetpackpractice.databinding.ActivityPagingBinding

class PagingActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPagingBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_paging)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer {
            Log.d("Response",it.myUserId.toString())
            Log.d("Response",it.id.toString())
            Log.d("Response",it.title)
            Log.d("Response",it.body)
        })
    }
}