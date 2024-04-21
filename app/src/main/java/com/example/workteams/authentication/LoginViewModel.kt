package com.example.workteams.authentication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.workteams.repository.UserRepository
import com.example.workteams.requests.LoginRequest
import com.example.workteams.responses.BaseResponse
import com.example.workteams.responses.LoginResponse
import kotlinx.coroutines.launch


class LoginViewModel(application: Application) : AndroidViewModel(application) {
    val userRepo by lazy {
        UserRepository()
    }
    private val _loginResult: MutableLiveData<BaseResponse<LoginResponse>> = MutableLiveData()
    val loginResult: LiveData<BaseResponse<LoginResponse>> = _loginResult

    fun loginUser(email: String, password: String) {
//        loginResult.BaseResponse.Loading()
        _loginResult.postValue(BaseResponse.Loading())
        viewModelScope.launch {
            val loginRequest = LoginRequest(email, password)
            val response = userRepo.loginUser(loginRequest)
            if (response is BaseResponse.Success) {
                _loginResult.postValue(response)
            } else if (response is BaseResponse.Error) {
                _loginResult.postValue(response)
            }
        }
    }
}







