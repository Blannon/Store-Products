package com.blannon_network.storeapppcleanarchtecture.store.data.mapper

import com.blannon_network.storeapppcleanarchtecture.store.domain.model.ApiError
import com.blannon_network.storeapppcleanarchtecture.store.domain.model.NetworkError
import retrofit2.HttpException

fun Throwable.toNetworkError():NetworkError{
    val error = when(this){
        is java.io.IOException -> ApiError.NetworkError
        is HttpException -> ApiError.UnknownResponse
        else -> ApiError.UnknownError
    }

    return NetworkError(
        error = error,
        t = this
    )
}