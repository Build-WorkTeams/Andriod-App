package com.example.workteams.authentication

import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.workteams.LoadingDialog
import com.example.workteams.MainActivity
import com.example.workteams.R
import com.example.workteams.databinding.FragmentLoginBinding
import com.example.workteams.responses.BaseResponse
import com.example.workteams.responses.LoginResponse

class LoginFragment : Fragment() {


    private lateinit var binding: FragmentLoginBinding
    private val viewModel by viewModels<LoginViewModel>()
    private val loadingDialog by lazy {
        LoadingDialog(requireActivity())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        // Screen setup
        val text = getString(R.string.don_t_have_an_account)
        setSpanText(text)
        registerNowClicked()
        forgotPasswordClicked()
        //


        viewModel.loginResult.observe(viewLifecycleOwner) { loginResponse ->
            when (loginResponse) {
                is BaseResponse.Loading -> {
                    showLoading()
                }

                is BaseResponse.Success -> {
                    stopLoading()
                    processLogin(loginResponse.data)
                }

                is BaseResponse.Error -> {
                    processError(loginResponse.msg)
                    stopLoading()
                }

                else -> {
                    stopLoading()
                }
            }
        }

        binding.loginBtn.setOnClickListener {
            doLogin()
        }

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

    private fun navigateToHome() {
        val intent = Intent(requireActivity(), MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        requireActivity().startActivity(intent)
    }

    private fun doLogin() {
        val email = binding.emailEt.text.toString()
        val password = binding.passwordEt.text.toString()
        viewModel.loginUser(email = email, password = password)
        // Extract the part of the email before the "@" symbol
        val username = email.substringBefore('@')
        println(username) //
        SessionManager.saveUsername(requireContext(), username)
//        Toast.makeText(
//            requireContext(),
//            "${SessionManager.getUsername(requireContext())}",
//            Toast.LENGTH_SHORT
//        ).show()
    }

    private fun saveUsername(username: String) {
        SessionManager.saveUsername(requireContext(), username)
    }

    private fun showLoading() {
//        binding.prgbar.visibility = View.VISIBLE
        loadingDialog.startLoadingDialog()
    }

    private fun stopLoading() {
//        binding.prgbar.visibility = View.GONE
        loadingDialog.dismissDialog()
    }

    private fun processLogin(data: LoginResponse?) {
        showToast("Success:" + data?.expiry)
        if (!data?.token.isNullOrEmpty()) {
            data?.token?.let { SessionManager.saveAuthToken(requireContext(), it) }
            navigateToHome()
        }
    }

    private fun processError(msg: String?) {
        showToast("Error:$msg")
    }

    private fun showToast(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }
}



