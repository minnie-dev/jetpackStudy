package com.example.jetpackstudy.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.jetpackstudy.R
import com.example.jetpackstudy.databinding.FragmentSecondnaviBinding

class SecondNaviFragment :Fragment(){

    private lateinit var binding : FragmentSecondnaviBinding

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_secondnavi,container,false)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(binding.root)

        binding.startBtn.setOnClickListener{
            navController.navigate(R.id.action_secondNaviFragment_to_ThirdNaviFragment)
        }
    }

}