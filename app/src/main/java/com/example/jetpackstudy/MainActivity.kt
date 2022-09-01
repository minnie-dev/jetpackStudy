package com.example.jetpackstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.jetpackstudy.databinding.ActivityMainBinding
import com.example.jetpackstudy.databinding.DataBindingActivity
import com.example.jetpackstudy.livedata.LiveDataActivity
import com.example.jetpackstudy.mvvm.ContactActivity
import com.example.jetpackstudy.navigation.NaviActivity
import com.example.jetpackstudy.paging.pagingex.PagingExActivity

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
            val intent = Intent(this,PagingExActivity::class.java)
            startActivity(intent)
        }

        binding.mvvmBtn.setOnClickListener {
            val intent = Intent(this,ContactActivity::class.java)
            startActivity(intent)
        }

    }

    /*fun solution( s: String): String {
        var answer = ""
        val array : List<String> =  s.split(" ")
        var appenStr =""

        for(i in 0.. array.size-1){
            if(array[i]!= " "){
                answer = array[i][0].toUpperCase().toString()
                var answerAfter = if (array[i].length>1)array[i].substring(1).toLowerCase()+" "
                else  " "
                appenStr+=(answer + answerAfter)
            }
        }
        var sttt = ""
        var arr = s.toLowerCase().split(" ").apply {
            this.forEachIndexed { index, s ->
                sttt += if (s.length > 1 && !s[0].equals(" ")){
                    s[0].toUpperCase() + s.substring(1) + " "
                }else if(s.length > 1 && s[0].equals(" ")){
                    s[1].toUpperCase() + s.substring(2) + " "
                }else if(s.length = 1 s[0].equals(" ")){
                    ""
                }else{
                    s[0].toUpperCase() + " "
                }
            }

        }
        println(arr.size)

        answer= sttt.substring(0,sttt.length-1)
        return answer
    }*/
}