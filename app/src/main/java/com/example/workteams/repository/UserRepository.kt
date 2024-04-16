package com.example.workteams.repository

import com.example.workteams.network.ApiClient
import com.example.workteams.requests.LoginRequest
import com.example.workteams.requests.RegisterRequest
import com.example.workteams.responses.LoginResponse
import com.example.workteams.responses.RegisterResponse
import retrofit2.Response

class UserRepository {
    suspend fun loginUser(loginRequest: LoginRequest): Response<LoginResponse> {
        return ApiClient.apiService.loginUser(loginRequest)
    }

    suspend fun registerUser(registerRequest: RegisterRequest): Response<RegisterResponse> {
        return ApiClient.apiService.registerUser(registerRequest)
    }
}