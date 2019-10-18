package com.info.billgenrator


import com.google.gson.annotations.SerializedName

data class CartItem(
    @SerializedName("notes")
    val notes: String,
    @SerializedName("quantity")
    val quantity: String,
    @SerializedName("selected_unit")
    val selectedUnit: String,
    var item:Item
)