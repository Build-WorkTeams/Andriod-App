package com.example.workteams.authentication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.workteams.repository.UserRepository
import com.example.workteams.requests.LoginRequest
import com.example.workteams.requests.RegisterRequest
import com.example.workteams.responses.BaseResponse
import com.example.workteams.responses.LoginResponse
import com.example.workteams.responses.RegisterResponse
import kotlinx.coroutines.launch


class RegisterViewModel(application: Application) : AndroidViewModel(application) {
    val userRepo by lazy {
        UserRepository()
    }
    private val _registerResult: MutableLiveData<BaseResponse<RegisterResponse>> = MutableLiveData()
    val registerResult: LiveData<BaseResponse<RegisterResponse>> = _registerResult

    fun registerUser(email: String, password: String) {
        _registerResult.postValue(BaseResponse.Loading())
        viewModelScope.launch {
            val registerRequest = RegisterRequest(email, password)
            val response = userRepo.registerUser(registerRequest)
            if (response is BaseResponse.Success) {
                _registerResult.postValue(response)
            } else if (response is BaseResponse.Error) {
                _registerResult.postValue(response)
            }
        }
    }

}

