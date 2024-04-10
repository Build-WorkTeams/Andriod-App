package com.example.workteams.onboarding


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.workteams.MainActivity
import com.example.workteams.R


class SplashScreen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*
        Navigate to new screen after 3 seconds delay
         */
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashScreen_to_welcomeScreen )
        },5000)
        //
        // Inflate the layout for this fragment
        return inflater.inflate(com.example.workteams.R.layout.fragment_splash_screen, container, false)
    }

}