package com.example.template.base

import androidx.lifecycle.ViewModel
import com.example.template.common.SingleLiveEvent

open class BaseViewModel: ViewModel() {

    val errorMessage = SingleLiveEvent<String>()

    fun setErrorMessage(error: String?) {
        if (error != null) {
            errorMessage.value = error
        }
    }
}