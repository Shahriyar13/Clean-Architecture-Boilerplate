package com.example.template.domain.common

sealed class MResult<out T> {
    // data received and is updated !
    data class Success<T>(val data: T?) : MResult<T>()

    //data received but its empty
    class SuccessEmpty<T> : MResult<T>()

    //receiving data has been failed :(
    data class Error<T>(val errorMessage: String) : MResult<T>()
}