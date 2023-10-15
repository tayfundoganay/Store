package com.example.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.databinding.FragmentProductListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment() {

    private var _binding: FragmentProductListBinding? = null

    private val viewModel by lazy {
        ViewModelProvider(this, defaultViewModelProviderFactory).get(ProductListViewModel::class.java)
    }

    private lateinit var productAdapter: ProductAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        recyclerView = _binding!!.recyclerView


        return _binding!!.root
    }



    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productAdapter = ProductAdapter()
        recyclerView.adapter = productAdapter
        val gridLayoutManager = GridLayoutManager(context, 2)
        recyclerView.layoutManager = gridLayoutManager


        viewModel.getLiveDataObserver().observe(viewLifecycleOwner) { products ->
            productAdapter.setList(products)
            productAdapter.notifyDataSetChanged()
        }

        viewModel.loadData()

        }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




