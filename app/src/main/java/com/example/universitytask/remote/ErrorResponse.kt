package com.example.universitytask.remote

data class ErrorResponse(
    val message: String,
    val errors: Map<String, List<String>>
)