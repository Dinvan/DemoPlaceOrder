package com.info.billgenrator


import com.google.gson.annotations.SerializedName

data class ItemUnit(
    @SerializedName("unit_id")
    val unitId: Int,
    @SerializedName("unit_name")
    val unitName: String
)