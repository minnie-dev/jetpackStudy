package com.example.jetpackstudy.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.jetpackstudy.R
import com.example.jetpackstudy.databinding.ActivityNaviBinding

class NaviActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNaviBinding
    lateinit var navController : NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_navi)
        binding.lifecycleOwner = this
        lateinit var navController : NavController

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        navController = navHostFragment!!.findNavController()
    }
}