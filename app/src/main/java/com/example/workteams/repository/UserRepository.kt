package com.example.workteams.repository

import com.example.workteams.network.ApiClient
import com.example.workteams.requests.LoginRequest
import com.example.workteams.requests.RegisterRequest
import com.example.workteams.responses.BaseResponse
import com.example.workteams.responses.LoginResponse
import com.example.workteams.responses.RegisterResponse
import retrofit2.Response

class UserRepository : BaseRepository() {

    //    suspend fun loginUser(loginRequest: LoginRequest): Response<LoginResponse> {
//        return ApiClient.apiService.loginUser(loginRequest)
//    }

//    suspend fun registerUser(registerRequest: RegisterRequest): Response<RegisterResponse> {
//        return ApiClient.apiService.registerUser(registerRequest)
//    }


//    suspend fun registerUser(registerRequest: RegisterRequest): BaseResponse<RegisterResponse> {
    suspend fun registerUser(registerRequest: RegisterRequest): BaseResponse<RegisterResponse> {
        // passing api function as an argument
        // in safeApiCall function
        return safeApiCall {
            ApiClient.apiService.registerUser(registerRequest)
        }
    }

    suspend fun loginUser(loginRequest: LoginRequest): BaseResponse<LoginResponse> {
        // passing api function as an argument
        // in safeApiCall function
        return safeApiCall {
            ApiClient.apiService.loginUser(loginRequest)
        }
    }

}