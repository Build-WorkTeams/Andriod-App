package com.example.workteams.authentication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
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
    val loginResult: MutableLiveData<BaseResponse<LoginResponse>> = MutableLiveData()

    fun loginUser(email: String, password: String) {
        loginResult.value = BaseResponse.Loading()
        viewModelScope.launch {
            try {
                val loginRequest = LoginRequest(email, password)
                val response = userRepo.loginUser(loginRequest)
                if (response.code() == 200) {
                    loginResult.value = BaseResponse.Success(response.body())
                } else {
                    val errorMessage = response.errorBody()?.string() ?: "Unknown error"
                    loginResult.value = BaseResponse.Error(errorMessage)
//                    loginResult.value = BaseResponse.Error(response.message())
                }
            } catch (ex: Exception) {
                loginResult.value = BaseResponse.Error(ex.message)
            }
        }
    }

}