package com.example.workteams.verification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.workteams.R
import com.example.workteams.databinding.FragmentCreateNewPasswordBinding

class CreateNewPassword : Fragment() {

    private lateinit var binding: FragmentCreateNewPasswordBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateNewPasswordBinding.inflate(inflater, container, false)
        resetPassword()
        return binding.root
    }

    private fun resetPassword(){
        binding.btnResetPassword.setOnClickListener {
            findNavController().navigate(R.id.action_createNewPassword_to_passwordChanged)
        }
    }

}