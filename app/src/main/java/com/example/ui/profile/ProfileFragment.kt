package com.example.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.R
import com.example.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment() {
    private var _binding : FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var fragmentTransaction: FragmentTransaction

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater,container,false)
        fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val firebaseAuth = FirebaseAuth.getInstance()
        // Giriş yapan kullanıcı bilgisini almak için `getCurrentUser()` metodunu kullanın
        val user = firebaseAuth.currentUser

        // Giriş yapan kullanıcı bilgisi varsa, `LoggedInProfileFragment`'i ekleyin
        if (user != null) {
            fragmentTransaction.replace(R.id.profileFragmentContainer, LoggedInProfileFragment())
            fragmentTransaction.commit()
        } else {
            // Giriş yapan kullanıcı bilgisi yoksa, `LoggedOutProfileFragment`'i ekleyin
            fragmentTransaction.replace(R.id.profileFragmentContainer, LoggedOutProfileFragment())
            fragmentTransaction.commit()
        }


        // Giriş yapan kullanıcı bilgisi varsa, `profileFragment`'in içeriğini değiştirin
        if (user != null) {
            // Kullanıcının adını ve e-posta adresini görüntüleyin

            val emailTextView = view.findViewById<TextView>(R.id.emailTextView)
            emailTextView!!.text = user.email

            // Çıkış yap fonksiyonunu ekleyin
            val logoutButton = view.findViewById<Button>(R.id.logoutButton)
            logoutButton!!.setOnClickListener {
                // Kullanıcıyı çıkış yapın
                firebaseAuth.signOut()

                // `profileFragment`'i iptal edin
                requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
            }
        } else {
            /*
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
*/
        }

    }

}