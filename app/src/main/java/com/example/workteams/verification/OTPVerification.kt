package com.example.workteams.verification

import android.content.Context
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.findNavController
import com.example.workteams.R
import com.example.workteams.databinding.FragmentOTPVerificationBinding


class OTPVerification : Fragment() {

    private lateinit var binding: FragmentOTPVerificationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOTPVerificationBinding.inflate(inflater, container, false)
        val text = getString(R.string.receive_code)
        setSpanText(text)
        showSoftKeyboard()
        verify()
        return binding.root
    }

    private fun showSoftKeyboard() {
        binding.pinView.requestFocus()
        // Get a reference to the InputMethodManager
//        val inputMethodManager = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        // Show the soft keyboard
//        inputMethodManager.showSoftInput(binding.pinView,InputMethodManager.SHOW_IMPLICIT)
//        WindowCompat.getInsetsController()
        val window = requireActivity().window
        val insetsController = WindowCompat.getInsetsController(window, binding.pinView)
        insetsController.show(WindowInsetsCompat.Type.ime())
    }


    private fun setSpanText(text: String) {
        val purple = ContextCompat.getColor(requireContext(), R.color.purple)
        val spannable = SpannableString(text)
        spannable.setSpan(ForegroundColorSpan(purple), 21, 27, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
        binding.receiveCode.text = spannable
    }

    private fun verify(){
        binding.btnVerify.setOnClickListener {
            findNavController().navigate(R.id.action_OTPVerification_to_createNewPassword)
        }
    }


}