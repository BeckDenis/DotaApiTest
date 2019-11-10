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
    val base_attack_min: Int,
    val base_attack_max: Int,
    val roles: List<String>,
    val move_speed: Int,
    val attack_range: Int,
    val legs: Int
) : Parcelable {
    val isAttackType
        get() = attack_type == "Melee"

    @IgnoredOnParcel
    val baseHealth = base_health.toString()
    @IgnoredOnParcel
    val baseMana = base_mana.toString()
    @IgnoredOnParcel
    val baseAttackMin = base_attack_min.toString()
    @IgnoredOnParcel
    val baseAttackMax = base_attack_max.toString()
    @IgnoredOnParcel
    val rolesString = roles.toString()
        .replace("[","")
        .replace("]","")
    @IgnoredOnParcel
    val moveSpeed = move_speed.toString()
    @IgnoredOnParcel
    val attackRange = attack_range.toString()
    @IgnoredOnParcel
    val legsString = legs.toString()
}


