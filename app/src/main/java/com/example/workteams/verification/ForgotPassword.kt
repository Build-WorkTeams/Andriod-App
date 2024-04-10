package com.example.workteams.verification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.workteams.R
import com.example.workteams.databinding.FragmentForgotPasswordBinding

class ForgotPassword : Fragment() {


    private lateinit var binding: FragmentForgotPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentForgotPasswordBinding.inflate(inflater,container,false)
        sendCode()
        return binding.root
    }

    private fun sendCode(){
        binding.btnSendCode.setOnClickListener {
            findNavController().navigate(R.id.action_forgotPassword_to_OTPVerification)
        }
    }

}