package com.example.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.databinding.FragmentProductDetailBinding

class ProductDetailFragment : Fragment() {

    private var _binding: FragmentProductDetailBinding? = null

    private val viewModel by lazy {
        ViewModelProvider(this, defaultViewModelProviderFactory).get(ProductDetailViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)



        return _binding!!.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
    fun observeLiveData(){
        viewModel.getLiveDataObserver().observe(viewLifecycleOwner){ products ->
            _binding?.detailProductImage


            }
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

