package com.karya.onlineshoping.fragments
import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.karya.onlineshoping.R
import com.karya.onlineshoping.databinding.FragmentLoginBinding

class LoginFrag : Fragment(R.layout.fragment_login) {

    lateinit var binding : FragmentLoginBinding
    lateinit var firebaseAuth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        firebaseAuth = FirebaseAuth.getInstance()


        onClicks() // Handle Click Events
        //emailFocusListener()  // emailValidation
        //passwordFocusListener() // passwordValidation

    }

    private fun onClicks() {

        binding.tvLoginRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFrag2_to_registerFrag)
        }
        /** Login Through Firebase Auth */
        binding.loginBtnLogIN.setOnClickListener {
            val email = binding.loginEtEmail.text.toString().trim()
            val pass = binding.loginEtPassword.text.toString().trim()

            if (email.isNotEmpty() && pass.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {

                    if (it.isSuccessful){
                        binding.loginEtEmail.text!!.clear()
                        binding.loginEtPassword.text!!.clear()
                        findNavController().navigate(R.id.action_loginFrag2_to_homeFrag)
                    }else{
                        Toast.makeText(context, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(context, "Fields Can't be Empty", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser != null){
            findNavController().navigate(R.id.action_loginFrag2_to_homeFrag)
        }
        /*else{
            findNavController().navigate(R.id.action_loginFrag2_to_registerFrag)
        }*/
    }

    /** emailValidation */
    /*private fun emailFocusListener() {
        binding.loginEtEmail.setOnFocusChangeListener{ _,focused->
            if (!focused){
                binding.editProTextInputEmail.helperText = validEmail()
                //binding.loginEtEmail.requestFocus()
            }
        }
    }
    private fun validEmail(): String? {
        val emailText = binding.loginEtEmail.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()){
            return null

        };return "Invalid Email Address"
    }
    *//** passwordValidation *//*
    private fun passwordFocusListener() {
        binding.loginEtPassword.setOnFocusChangeListener{ _,focused->
            if (!focused){
                binding.editProTextInputPassword.helperText = validPassword()
            }
        }
    }
    private fun validPassword(): String? {
        val passwordText = binding.loginEtPassword.text.toString()
        if(passwordText.length < 8){
            return "Minimum 8 Characters Required"
        }
        if (!passwordText.matches(".*[A-Z].*".toRegex())){
            return "Must Contain 1 Upper-Case Letter."
        }
        if (!passwordText.matches(".*[a-z].*".toRegex())){
            return "Must Contain 1 Lower-Case Letter."
        }
        if (!passwordText.matches(".*[@#\$%^&+=].*".toRegex())){
            return "Must Contain 1 Special Character (@#\$%^&+=)."
        }
        return null
    }*/
}