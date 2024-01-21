package com.example.rickandmortymvi.core

sealed class Resources<T>(val data:T?=null, val error:String?=null){
    class Success<T>(data: T):Resources<T>(data = data)
    class Error<T>(error: String):Resources<T>(error = error)
}