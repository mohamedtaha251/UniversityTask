package com.example.universitytask.di

import com.example.universitytask.response.UniversityListResponse
import org.json.JSONObject
import retrofit2.http.GET


interface ApiService {
    @GET("http://universities.hipolabs.com/search?country=United%20Arab%20Emirate")
    suspend fun getUniversities(): UniversityListResponse
}