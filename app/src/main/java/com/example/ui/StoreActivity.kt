package com.example.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.R
import com.example.data.model.Product
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoreActivity : AppCompatActivity() {


    val viewModel by lazy {
        ViewModelProvider(this,defaultViewModelProviderFactory).get(ProductViewModel::class.java)
    }

    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productAdapter = ProductAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = productAdapter

        viewModel.getLiveDataObserver().observe(this, object: Observer<List<Product>> {
            override fun onChanged(t: List<Product>?) {
                if (t != null)
                {
                    productAdapter.setList(t)
                    productAdapter.notifyDataSetChanged()
                }
            }
        })

        viewModel.loadData()
    }
}