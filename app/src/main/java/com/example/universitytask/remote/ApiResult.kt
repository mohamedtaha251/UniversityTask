package com.example.universitytask.remote

sealed class ApiResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : ApiResult<T>()
    data class Error(val message: String? = null) : ApiResult<Nothing>()
}