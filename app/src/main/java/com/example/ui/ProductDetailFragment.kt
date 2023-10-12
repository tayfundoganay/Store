package com.example.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.databinding.FragmentProductDetailBinding

class ProductDetailFragment : Fragment() {

    private lateinit var binding: FragmentProductDetailBinding

    private val viewModel by lazy {
        ViewModelProvider(this, defaultViewModelProviderFactory).get(ProductDetailViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentProductDetailBinding.inflate(layoutInflater)


        var productImage : ImageView = binding.detailProductImage
        var productTitle : TextView = binding.productTitle
        var productDescription : TextView = binding.productDescription
        var productPrice : TextView = binding.productPrice


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
    fun observeLiveData(){
        viewModel.getLiveDataObserver().observe(viewLifecycleOwner){ products ->
            binding.detailProductImage


            }
        }
    }

