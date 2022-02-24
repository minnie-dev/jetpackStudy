package com.example.jetpackpractice.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.jetpackpractice.R
import com.example.jetpackpractice.databinding.FragmentThirdnaviBinding

class ThirdNaviFragment : Fragment(){
    private lateinit var binding : FragmentThirdnaviBinding

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_thirdnavi,container,false)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(binding.root)

        binding.startBtn.setOnClickListener{
            navController.navigate(R.id.action_ThirdNaviFragment_to_firstNaviFragment)
        }
    }
}