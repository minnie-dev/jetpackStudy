package com.example.jetpackstudy.livedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.jetpackstudy.R
import com.example.jetpackstudy.databinding.ActivityLivedataBinding

class LiveDataActivity : AppCompatActivity() {

    private var count = 0
    var mutableLiveText = MutableLiveData<String>() // livedata는 불변하기 때문에 갱신할 수 없다 하지만 mutablelivedata는 livedate를 상속받아 변경가능
    val liveText : LiveData<String>
        get()=mutableLiveText

    lateinit var binding : ActivityLivedataBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_livedata)

        //lifecyclerowner를 첫번째 인자로 전달합니다. 이를 통해 livedata에 lifecycle소유자와 바인딩
        // LiveData를 Observer를 이용해 관찰하고 현재 Activity 및 Observer를 LifeCyclerOwner로 전달
        liveText.observe(this, Observer{// observe 메소드를 통해  Observer 붙일 수 있음
            binding.textTest.text = it
        })

        binding.btnChange.setOnClickListener{
            mutableLiveText.value = "LiveData Test ${++count}"
        }

    }
}