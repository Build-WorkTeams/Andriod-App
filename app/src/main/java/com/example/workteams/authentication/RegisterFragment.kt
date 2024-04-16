package com.example.workteams.authentication

import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.workteams.LoadingDialog
import com.example.workteams.R
import com.example.workteams.databinding.FragmentRegisterBinding
import com.example.workteams.responses.BaseResponse

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private val viewModel by viewModels<RegisterViewModel>()
    private val loadingDialog by lazy {
        LoadingDialog(requireActivity())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        // Screen setup
        val text = getText(R.string.already_have_an_account)
        setSpanText(text.toString())
        loginNowClicked()
        //
        viewModel.registerResult.observe(viewLifecycleOwner) { registerResponse ->
            when (registerResponse) {
                is BaseResponse.Loading -> {
                    showLoading()
                }

                is BaseResponse.Success -> {
                    stopLoading()
                    showToast("User Registered Successfully")
                    navigateToLogin()
                }

                is BaseResponse.Error -> {
                    processError(registerResponse.msg)
                    stopLoading()
                }

                else -> {
                    stopLoading()
                }
            }
        }

        binding.joinUsBtn.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val password = binding.passwordEt.text.toString()
            val confirmPassword = binding.confirmPasswordEt.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                if (password != confirmPassword) {
                    binding.passwordEt.error = "Password must match with confirm password"
                    binding.confirmPasswordEt.error = "Password must match with confirm password"
                } else {
                    doRegister()
                }
            } else {
                if (email.isEmpty()) {
                    binding.emailEt.error = "Email field can't be empty"
                }
                if (password.isEmpty()) {
                    binding.passwordEt.error = "Password field can't be empty"
                }
            }
        }
        return binding.root
    }

    private fun setSpanText(text: String) {
        val purple = ContextCompat.getColor(requireContext(), R.color.purple)
        val spannable = SpannableString(text)
        spannable.setSpan(ForegroundColorSpan(purple), 25, 34, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
        binding.loginNow.text = spannable
    }

    private fun loginNowClicked() {
        binding.loginNow.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }


    private fun navigateToLogin() {
        findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
    }

    private fun doRegister() {
        val email = binding.emailEt.text.toString()
        val password = binding.passwordEt.text.toString()
        viewModel.registerUser(email = email, password = password)
    }

    private fun showLoading() {
//        binding.prgbar.visibility = View.VISIBLE
        loadingDialog.startLoadingDialog()
    }

    private fun stopLoading() {
//        binding.prgbar.visibility = View.GONE
        loadingDialog.dismissDialog()
    }


    private fun processError(msg: String?) {
        showToast("Error: $msg")
    }

    private fun showToast(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }
}





