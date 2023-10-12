package com.example.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.R
import com.example.data.model.Product
import com.example.databinding.FragmentProductListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment() {

    private lateinit var binding: FragmentProductListBinding

    private val viewModel by lazy {
        ViewModelProvider(this, defaultViewModelProviderFactory).get(ProductListViewModel::class.java)
    }

    private lateinit var productAdapter: ProductAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductListBinding.inflate(inflater, container, false)
        recyclerView = binding.recyclerView



        return binding.root
    }


    private fun navigateToProductDetail() {
        // Use the NavController to navigate to the ProductDetailFragment
        findNavController().navigate(R.id.action_productListFragment_to_productDetailFragment)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productAdapter = ProductAdapter()
        recyclerView.adapter = productAdapter
        val gridLayoutManager = GridLayoutManager(context, 2)
        recyclerView.layoutManager = gridLayoutManager

        recyclerView.setOnClickListener{
            navigateToProductDetail()
        }

        viewModel.getLiveDataObserver().observe(viewLifecycleOwner) { products ->
            productAdapter.setList(products)
            productAdapter.notifyDataSetChanged()
        }

        viewModel.loadData()



        }
    }

    private fun getProductId(product: Product): Int {
        return product.id

    }


