package com.example.jetpackpractice.paging.pagingex

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpackpractice.databinding.ActivityPagingexBinding
import com.example.jetpackpractice.paging.pagingex.adapter.MyAdapter
import com.example.jetpackpractice.paging.pagingex.viewmodel.MainViewModel
import com.example.jetpackpractice.paging.pagingex.viewmodel.MainViewModelFactory

class PagingExActivity : AppCompatActivity(){
    private lateinit var viewModel: MainViewModel
    private lateinit var binding :ActivityPagingexBinding
    private val myAdapter by lazy{MyAdapter()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagingexBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = myAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        val repository = MyPagingRepository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        binding.button.setOnClickListener {
            viewModel.searchPost(Integer.parseInt(binding.editTextView.text.toString()))
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(binding.editTextView.windowToken,0)
        }

        viewModel.result.observe(this, Observer {
            myAdapter.submitData(this.lifecycle,it)
        })


    }
}