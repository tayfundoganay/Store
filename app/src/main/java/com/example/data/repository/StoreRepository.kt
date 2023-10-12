package com.example.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.data.model.Product
import com.example.data.service.StoreServiceAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class StoreRepository @Inject constructor(private val storeServiceAPI: StoreServiceAPI) {

    fun getProducts(liveData: MutableLiveData<List<Product>>) {


        val call: Call<List<Product>> = storeServiceAPI.getProducts()
        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    liveData.postValue(response.body())
                } else
                    liveData.postValue(null)
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                liveData.postValue(null)
            }

        })
    }
}