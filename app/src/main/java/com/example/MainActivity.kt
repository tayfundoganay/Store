package com.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.databinding.ActivityMainBinding
import com.example.ui.ProductAdapter
import com.example.ui.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController : NavController
    val viewModel by lazy {
        ViewModelProvider(this,defaultViewModelProviderFactory).get(ProductViewModel::class.java)
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController

    }

    override fun onSupportNavigateUp(): Boolean {
        navController = findNavController(R.id.navHostFragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


        /*
                productAdapter = ProductAdapter()
                val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                recyclerView.adapter = productAdapter
                val gridLayoutManager : GridLayoutManager = GridLayoutManager(this,2)
                recyclerView.setLayoutManager(gridLayoutManager)


                viewModel.getLiveDataObserver().observe(this, object: Observer<List<Product>> {
                    override fun onChanged(t: List<Product>?) {
                        if (t != null)
                        {
                            productAdapter.setList(t)
                            productAdapter.notifyDataSetChanged()
                        }
                    }
                })*/

        //viewModel.loadData()

}