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
import com.example.workteams.R
import com.example.workteams.databinding.FragmentFirstOBScreenBinding

class FirstOBScreen : Fragment() {

    private lateinit var binding: FragmentFirstOBScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstOBScreenBinding.inflate(inflater, container, false)
        /*
        Set Spannable text
         */
        val spanText = "Define your Objectives"
        setSpanText(spanText)
        return binding.root
    }

    private fun setSpanText(text: String) {
        val purple = ContextCompat.getColor(requireContext(), R.color.purple)
        val spannable = SpannableString(text)
        spannable.setSpan(ForegroundColorSpan(purple), 12, 22, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
        binding.objTxt.text = spannable
    }


}