package com.example.workteams.onboarding


import android.content.Intent
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
import com.example.workteams.authentication.SessionManager


class SplashScreen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*
        Navigate to new screen after 3 seconds delay
         */
        Handler(Looper.getMainLooper()).postDelayed({
            val token = SessionManager.getToken(requireContext())
            if (!token.isNullOrBlank()) {
                navigateToHome()
            } else {
//                findNavController().navigate(R.id.action_splashScreen_to_welcomeScreen)
            }
        }, 3000)
        //
        // Inflate the layout for this fragment
        return inflater.inflate(
            com.example.workteams.R.layout.fragment_splash_screen,
            container,
            false
        )
    }


    private fun navigateToHome() {
        val intent = Intent(requireActivity(), MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        requireActivity().startActivity(intent)
    }

}