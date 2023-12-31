package com.example.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.model.Product
import com.example.data.repository.StoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(private val repository: StoreRepository) : ViewModel() {

    var liveData: MutableLiveData<List<Product>> = MutableLiveData()

    fun getLiveDataObserver(): MutableLiveData<List<Product>> {
        return liveData
    }

    fun loadData() {
        repository.getProducts(liveData)
    }
}