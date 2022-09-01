package com.example.jetpackstudy.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.jetpackstudy.R

class DataBindingActivity : AppCompatActivity()  {

    lateinit var binding : ActivityDatabindingBinding

    var test = "Test"
    var testInclude = "Include"
    private var count = 0
    private var includeCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding)

        binding.apply {
            activity = this@DataBindingActivity
            btnChange.setOnClickListener {
                test = "Test ${++count}"
                testInclude = "Include ${++includeCount}"

                invalidateAll()
            }
        }
    }
}