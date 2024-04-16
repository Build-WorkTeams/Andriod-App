package com.example.workteams.network

import com.example.workteams.requests.LoginRequest
import com.example.workteams.requests.RegisterRequest
import com.example.workteams.responses.LoginResponse
import com.example.workteams.responses.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {


    @POST("api/accounts/register/")
//    @POST("accounts/accounts_register_create")
    suspend fun registerUser(
        @Body registerRequest: RegisterRequest
    ): Response<RegisterResponse>

    @POST("api/accounts/login/")
//    @POST("accounts/accounts_login_create")
    suspend fun loginUser(
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>
}