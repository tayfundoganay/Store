package com.example

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.databinding.ActivityMainBinding
import com.example.ui.DashboardFragment
import com.example.ui.ProductAdapter
import com.example.ui.ProductListFragment
import com.example.ui.ProductListViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel by lazy {
        ViewModelProvider(
            this,
            defaultViewModelProviderFactory
        ).get(ProductListViewModel::class.java)
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var productAdapter: ProductAdapter
    private lateinit var navView: BottomNavigationView
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment


        navController = navHostFragment.navController

        navView = findViewById(R.id.nav_view)

        navView.setupWithNavController(navController)

        fun onSupportNavigateUp(): Boolean {
            return navController.navigateUp() || super.onSupportNavigateUp()
        }



    }

    fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_home -> {
                val productListFragment = ProductListFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.navHostFragment, productListFragment)
                    .commit()
                return true
            }

            R.id.navigation_dashboard -> {
                val dashboardFragment = DashboardFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.navHostFragment, dashboardFragment)
                    .commit()
                // Handle dashboard click
                return true
            }

        }
        return false
    }



}