package com.example.workteams.authentication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.workteams.repository.UserRepository
import com.example.workteams.requests.RegisterRequest
import com.example.workteams.responses.BaseResponse
import com.example.workteams.responses.RegisterResponse
import kotlinx.coroutines.launch


class RegisterViewModel(application: Application) : AndroidViewModel(application) {
    val userRepo by lazy {
        UserRepository()
    }
    val registerResult: MutableLiveData<BaseResponse<RegisterResponse>> = MutableLiveData()

    fun registerUser(email: String, password: String) {
        registerResult.value = BaseResponse.Loading()
        viewModelScope.launch {
            try {
                val regisRequest = RegisterRequest(email, password)
                val response = userRepo.registerUser(regisRequest)
                if (response.code() == 201) {
                    registerResult.value = BaseResponse.Success(response.body())
                } else {
                    val errorMessage = response.errorBody()?.string() ?: "Unknown error"
                    registerResult.value = BaseResponse.Error(errorMessage)
//                    registerResult.value = BaseResponse.Error(response.message())
                }
            } catch (ex: Exception) {
                registerResult.value = BaseResponse.Error(ex.message)
            }
        }
    }

}