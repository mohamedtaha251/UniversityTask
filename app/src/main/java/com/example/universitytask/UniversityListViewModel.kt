package com.example.universitytask

import com.example.universitytask.base.BaseViewModel
import com.example.universitytask.remote.ApiResult
import com.example.universitytask.remote.MainRepo
import com.example.universitytask.response.UniversityListResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UniversityListViewModel @Inject constructor(
    private val repo: MainRepo
) : BaseViewModel() {


    fun getUniversities(onSuccess: ((UniversityListResponse) -> Unit)? = null) {
        launchWithLoading {
            when (val result = repo.getUniversities()) {
                is ApiResult.Success -> {
                    onSuccess?.invoke(result.data)
                }

                is ApiResult.Error -> {
                    errorLD.postValue(result.message)
                }
            }
        }
    }


}