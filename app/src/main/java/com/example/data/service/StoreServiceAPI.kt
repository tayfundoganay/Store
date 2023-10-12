package com.example.data.service

import com.example.data.model.Product
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.http.GET

interface StoreServiceAPI {

    //@Headers("$API_KEY")
    @GET("products")
    fun getProducts() : Call<List<Product>>
}