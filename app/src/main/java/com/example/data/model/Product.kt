package com.example.data.model

import com.google.gson.annotations.SerializedName

data class Product(

    @SerializedName("id")
    val productId: Int?,
    @SerializedName("title")
    val productTitle: String?,
    @SerializedName("price")
    val productPrice: Double?,
    @SerializedName("description")
    val productDescription: String?,
    @SerializedName("category")
    val productCategory: String?,
    @SerializedName("image")
    val productImageUrl: String?,
    @SerializedName("rating")
    val productRating: Rating?

)