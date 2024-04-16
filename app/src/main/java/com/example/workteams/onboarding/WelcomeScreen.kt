package com.example.workteams.onboarding


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.workteams.GlobalVariables
import com.example.workteams.R
import com.example.workteams.databinding.FragmentWelcomeScreenBinding
import com.example.workteams.onboarding.screens.FirstOBScreen
import com.example.workteams.onboarding.screens.SecondOBScreen
import com.example.workteams.onboarding.screens.ThirdOBScreen


class WelcomeScreen : Fragment() {

    private lateinit var binding: FragmentWelcomeScreenBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Access the activity's root view
        val rootView = requireActivity().window.decorView.rootView

        // Set the background color of the activity's root view
        rootView.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWelcomeScreenBinding.inflate(inflater, container, false)
        val loggedOut = GlobalVariables.isLogOutClicked
        if (loggedOut) {
            GlobalVariables.isLogOutClicked = false
            findNavController().navigate(R.id.action_welcomeScreen_to_loginFragment)
        }


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

    private fun regulateIndicator() {
        binding.welcomeViewpager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                // Call when a new page is selected
                if (position == 2) {
                    binding.pageIndicator.visibility = View.INVISIBLE
                } else {
                    binding.pageIndicator.visibility = View.VISIBLE
                }
            }
        })
    }


}
