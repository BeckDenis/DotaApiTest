package com.example.dotaapitest.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DotaProperty(
    val id: Int,
    val name: String,
    val localized_name: String,
    val img: String,
    val icon: String,
    val attack_type: String
) : Parcelable {
    val isAttackType
        get() = attack_type == "Melee"
}


