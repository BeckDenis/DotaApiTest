package com.example.dotaapitest.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET

data class DotaProperty(
    val id: Int,
    val name: String,
    val img: String
)

