package com.example.dotaapitest.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET

data class DotaProperty(
    val id: Int,
    val name: String,
    val localized_name: String,
    val img: String,
    val icon: String,
    val attack_type: String
) {
    val isAttackType
        get() = attack_type == "Melee"
}


