package com.example.workteams.onboarding


import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.workteams.MainActivity
import com.example.workteams.databinding.FragmentWelcomeScreenBinding
import com.example.workteams.onboarding.screens.FirstOBScreen
import com.example.workteams.onboarding.screens.SecondOBScreen
import com.example.workteams.onboarding.screens.ThirdOBScreen
import me.relex.circleindicator.CircleIndicator


class WelcomeScreen : Fragment() {

    private lateinit var binding: FragmentWelcomeScreenBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWelcomeScreenBinding.inflate(inflater, container, false)

        /*
       List of Fragments to be
       displayed by the viewpage
        */
        val fragmentList = arrayListOf<Fragment>(
            FirstOBScreen(),
            SecondOBScreen(),
            ThirdOBScreen()
        )
        /*
        Viewpager Adapter
         */
        val adapter = WelcomeScreenViewPager(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        binding.welcomeViewpager.adapter = adapter

        /*
        Circle indicator
         */
        binding.pageIndicator.setViewPager(binding.welcomeViewpager)
        regulateIndicator()
        return binding.root
    }

    private fun regulateIndicator(){
        binding.welcomeViewpager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                // Call when a new page is selected
                if(position == 2){
                    binding.pageIndicator.visibility = View.INVISIBLE
                }else{
                    binding.pageIndicator.visibility = View.VISIBLE
                }
            }
        })
    }



}