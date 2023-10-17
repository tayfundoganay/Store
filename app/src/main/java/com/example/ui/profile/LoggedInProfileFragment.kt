package com.example.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.R
import com.example.databinding.FragmentLoggedInProfileBinding
import com.google.firebase.auth.FirebaseAuth

class LoggedInProfileFragment : Fragment() {

    private var _binding : FragmentLoggedInProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoggedInProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val firebaseAuth = FirebaseAuth.getInstance()
        // Giriş yapan kullanıcı bilgisini almak için `getCurrentUser()` metodunu kullanın
        val user = firebaseAuth.currentUser

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

                val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.navHostFragment, LoggedOutProfileFragment())
                fragmentTransaction.commit()
            }
        }
    }
}