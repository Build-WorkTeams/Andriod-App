package com.example.workteams.verification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.workteams.R
import com.example.workteams.databinding.FragmentPasswordChangedBinding

class PasswordChanged : Fragment() {


    private lateinit var binding: FragmentPasswordChangedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPasswordChangedBinding.inflate(inflater,container,false)
        backToLogin()
        return binding.root
    }

    private fun backToLogin(){
        binding.btnBackToLogin.setOnClickListener {
            findNavController().navigate(R.id.action_passwordChanged_to_loginFragment)
        }
    }

}