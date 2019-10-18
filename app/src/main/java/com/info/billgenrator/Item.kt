package com.info.billgenrator


import com.google.gson.annotations.SerializedName

data class Item(

    @SerializedName("item_name")
    val itemName: String,
    @SerializedName("item_company_name")
    val itemCompanyName: String,
    @SerializedName("item_image")
    val itemImage: String,
    @SerializedName("item_units")
    val units: ArrayList<ItemUnit>,
    var isSelected: Boolean,
    var isAdded: Boolean
)