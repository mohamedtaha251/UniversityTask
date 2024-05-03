package com.example.universitytask.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

open class BaseViewModel : ViewModel() {
    var errorLD = MutableLiveData<String?>()
    var loadingLD = MutableLiveData<Boolean>()


    protected fun ViewModel.launchWithLoading(
        block: suspend () -> Unit
    ) {
        loadingLD.postValue(true)
        viewModelScope.launch {
            try {
                withContext(Dispatchers.Main) {
                    block()
                }
            } finally {
                loadingLD.postValue(false)
            }
        }
    }
}