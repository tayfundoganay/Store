package com.example.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.R
import com.example.databinding.FragmentLoggedOutProfileBinding
import com.example.ui.auth.LoginFragment
import com.example.ui.auth.RegisterFragment

class LoggedOutProfileFragment : Fragment(){
    private var _binding : FragmentLoggedOutProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoggedOutProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.profileLoginRedirectText.setOnClickListener{
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.navHostFragment, LoginFragment())
            fragmentTransaction.commit()
        }
        binding.profileSignupRedirectText.setOnClickListener{
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.navHostFragment, RegisterFragment())
            fragmentTransaction.commit()
        }
    }


}