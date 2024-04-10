package com.example.workteams.authentication

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.workteams.R
import com.example.workteams.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {


    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        val text = getString(R.string.don_t_have_an_account)
        setSpanText(text)
        registerNowClicked()
        forgotPasswordClicked()
        return binding.root

    }

    private fun setSpanText(text: String) {
        val purple = ContextCompat.getColor(requireContext(), R.color.purple)
        val spannable = SpannableString(text)
        spannable.setSpan(ForegroundColorSpan(purple), 23, 35, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
        binding.registerNow.text = spannable
    }

    private fun registerNowClicked() {
        binding.registerNow.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun forgotPasswordClicked() {
        binding.forgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_forgotPassword)
        }
    }
}