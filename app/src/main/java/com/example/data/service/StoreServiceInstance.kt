package com.example.data.service

import com.example.data.model.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface StoreServiceInstance {

    //@Headers("$API_KEY")
    @GET("products")
    fun getPosts() : Call<List<Product>>
}