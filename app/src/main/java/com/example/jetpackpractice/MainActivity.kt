package com.example.jetpackpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.jetpackpractice.databinding.ActivityMainBinding
import com.example.jetpackpractice.databinding.DataBindingActivity
import com.example.jetpackpractice.livedata.LiveDataActivity
import com.example.jetpackpractice.mvvm.ContactActivity
import com.example.jetpackpractice.navigation.NaviActivity
import com.example.jetpackpractice.paging.PagingActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.dataBindingBtn.setOnClickListener {
            val intent = Intent(this,DataBindingActivity::class.java)
            startActivity(intent)
        }

        binding.liveDataBtn.setOnClickListener {
            val intent = Intent(this,LiveDataActivity::class.java)
            startActivity(intent)
        }

        binding.naviBtn.setOnClickListener {
            val intent = Intent(this,NaviActivity::class.java)
            startActivity(intent)
        }

        binding.pagingBtn.setOnClickListener {
            val intent = Intent(this,PagingActivity::class.java)
            startActivity(intent)
        }

        binding.mvvmBtn.setOnClickListener {
            val intent = Intent(this,ContactActivity::class.java)
            startActivity(intent)
        }

    }
}