package com.example.universitytask.remote

import com.google.gson.Gson
import retrofit2.HttpException

open class BaseRepo {

    suspend fun <T : Any> safeApiCall(apiCall: suspend () -> T): ApiResult<T> {
        return try {
            val result = apiCall.invoke()
            ApiResult.Success(result)
        } catch (e: Exception) {
            handleException(e)
        }
    }

    private fun <T : Any> handleException(e: Exception): ApiResult<T> {
        return when (e) {
            is HttpException -> {
                val code = e.code()
                val errorMessage = convertErrorBody(e)
                ApiResult.Error("$code:$errorMessage")
            }

            else -> {
                ApiResult.Error("${e.message}:${e.localizedMessage}")
            }
        }
    }

    private fun convertErrorBody(exception: HttpException): String? {
        return try {
            val jsonStr = exception.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(jsonStr, ErrorResponse::class.java)
            return errorResponse.message
        } catch (e: Exception) {
            null
        }
    }
}
