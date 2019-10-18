package com.info.billgenrator


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ShoppingListModel(
    @SerializedName("item_count")
    val itemCount: Int,
    @SerializedName("shopping_list_name")
    val shoppingListName: String
) :Serializable