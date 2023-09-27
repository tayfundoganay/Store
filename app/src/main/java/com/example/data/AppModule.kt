package com.example.data

import com.example.data.service.StoreServiceInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

class AppModule {

    val BASE_URL = "https://fakestoreapi.com/"

    @Singleton
    @Provides
    fun getStoreServiceInstance(retrofit: Retrofit): StoreServiceInstance
    {
        return retrofit.create(StoreServiceInstance::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitInstance() : Retrofit
    {
        return  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}