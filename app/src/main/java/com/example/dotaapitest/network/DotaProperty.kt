package com.example.dotaapitest.network

import android.os.Parcelable
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DotaProperty(
    val id: Int,
    val name: String,
    val localized_name: String,
    val img: String,
    val icon: String,
    val attack_type: String,
    val base_health: Int,
    val base_mana: Int,
    val base_attack_min: Int
) : Parcelable {
    val isAttackType
        get() = attack_type == "Melee"

    @IgnoredOnParcel
    val baseHealth = base_health.toString()
    @IgnoredOnParcel
    val baseMana = base_mana.toString()
    @IgnoredOnParcel
    val baseAttackMin = base_attack_min.toString()
}


