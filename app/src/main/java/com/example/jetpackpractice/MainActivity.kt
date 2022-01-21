package com.example.jetpackpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.jetpackpractice.databinding.ActivityMainBinding
import com.example.jetpackpractice.databinding.DataBindingActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.dataBindingBtn.setOnClickListener {
            val intent = Intent(this,DataBindingActivity::class.java)
            startActivity(intent)
        }
    }
}