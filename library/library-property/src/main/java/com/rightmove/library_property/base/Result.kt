package com.rightmove.library_property.base

sealed class Result<out T> {
    data class Success<out T>(val value: T) : Result<T>()
    data class Error(val message: String? = null) : Result<Nothing>()
}