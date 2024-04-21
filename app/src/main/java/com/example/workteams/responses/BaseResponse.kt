package com.example.workteams.responses


sealed class BaseResponse<out T>(
    val data: T? = null,
    val message: String? = null
) {

    // Wrap data in this Success class
    class Success<T>(data: T?) : BaseResponse<T>(data = data)

    // Pass error message in this Error class to be used un case of
    // failure response
    class Error<T>(errorMessage: String?) : BaseResponse<T>(message = errorMessage)

    // Loading
    class Loading<T> : BaseResponse<T>()

//    // Wrap data in this Success class
//    data class Success<out T>( data: T?) : BaseResponse<T>()
//    data class Loading(val nothing: Nothing? = null) : BaseResponse<Nothing>()
//
//    // Pass error message in this Error class to be used un case of
//    // failure response
//    data class Error(val errorMessage: String?) : BaseResponse<Nothing>()
}

