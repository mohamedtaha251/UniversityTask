package com.example.universitytask.response

data class UniversityListResponseItem(
    val alpha_two_code: String,
    val country: String,
    val domains: List<String>,
    val name: String,
    val web_pages: List<String>
)