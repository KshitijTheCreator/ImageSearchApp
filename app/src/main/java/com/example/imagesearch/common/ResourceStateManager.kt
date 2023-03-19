package com.example.imagesearch.common

sealed class ResourceStateManager<T>(val data:T?=null, val message:String?=null){
    class Success<T>(data: T?): ResourceStateManager<T>(data = data)
    class Loading<T>(): ResourceStateManager<T>()
    class Error<T>(message: String): ResourceStateManager<T>(message = message)
}
