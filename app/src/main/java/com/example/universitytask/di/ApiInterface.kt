package com.example.universitytask.di

import org.json.JSONObject
import retrofit2.http.GET


internal interface ApiService {
    @GET("http://universities.hipolabs.com/search?country=United%20Arab%20Emirate")
    suspend fun getList(): List<JSONObject>
}