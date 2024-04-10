package com.example.workteams.onboarding.screens

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
import com.example.workteams.databinding.FragmentFirstOBScreenBinding
import com.example.workteams.databinding.FragmentSecondOBScreenBinding
import com.example.workteams.databinding.FragmentThirdOBScreenBinding

class ThirdOBScreen : Fragment() {

    private lateinit var binding: FragmentThirdOBScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentThirdOBScreenBinding.inflate(inflater, container, false)
        /*
        Set Spannable text
         */
        val spanText = "Track your progress"
        setSpanText(spanText)
        /*
        Set get started button listener
         */
        getStarted()
        return binding.root
    }

    private fun setSpanText(text: String) {
        val purple = ContextCompat.getColor(requireContext(), R.color.purple)
        val spannable = SpannableString(text)
        spannable.setSpan(ForegroundColorSpan(purple), 11, 19, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
        binding.trackProTxt.text = spannable
    }

    private fun getStarted() {
        binding.btnGetStarted.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeScreen_to_registerFragment)
        }
    }


}