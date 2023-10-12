package com.example.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment() {

    private lateinit var binding: FragmentCategoriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentCategoriesBinding.inflate(layoutInflater)
    }
}