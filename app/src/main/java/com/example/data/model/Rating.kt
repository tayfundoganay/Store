package com.example.data.model

import com.google.gson.annotations.SerializedName

data class Rating(

    @SerializedName("rate")
    val productRate: Double?,
    @SerializedName("count")
    val productRateCount: Int?

)
