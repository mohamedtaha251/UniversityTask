package com.example.universitytask.remote

import com.example.universitytask.di.ApiService
import com.example.universitytask.response.UniversityListResponse
import javax.inject.Inject


class MainRepo @Inject constructor(
    private val api: ApiService,
) : BaseRepo() {


    suspend fun getUniversities(): ApiResult<UniversityListResponse> =
        safeApiCall { api.getUniversities() }
}