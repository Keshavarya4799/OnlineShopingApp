package com.karya.onlineshoping.fragments

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.karya.onlineshoping.R
import com.karya.onlineshoping.databinding.FragmentRegisterBinding

//
class RegisterFrag : Fragment(R.layout.fragment_register) {

    lateinit var binding: FragmentRegisterBinding
    lateinit var firebaseAuth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterBinding.bind(view)
        firebaseAuth = FirebaseAuth.getInstance()

        onClicks()
        //emailFocusListener()  // emailValidation
        //passwordFocusListener() // passwordValidation

    }

    private fun onClicks() {
        binding.tvSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_registerFrag_to_loginFrag2)
        }
        /** Registration Through FirebaseAuth */
        binding.registerBtnSignUp.setOnClickListener {
            val name = binding.etFullName.text.toString().trim()
            val email = binding.registerEtEmail.text.toString().trim()
            val pass = binding.registerEtPass.text.toString().trim()
            if (email.isNotEmpty() && pass.isNotEmpty()){
                firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(context, "$name Registered", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_registerFrag_to_loginFrag2)
                    }else{
                        Toast.makeText(context, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(context, "Fields Can't be Empty", Toast.LENGTH_SHORT).show()
            }
        }
        
    }

    /* private fun validateFullName():Boolean{

         var errorMessage:String? = null
         val value:String = binding.etFullName.text.toString()
         if(value.isEmpty()){
             errorMessage = "Full Name is Required"
         }
         if (errorMessage != null){
             binding.editProTextInputFullName.apply {
                 isErrorEnabled = true
                 error = errorMessage
             }
         }
         return errorMessage == null

     }*/

    /*private fun validateEmail():Boolean{

        var errorMessage:String? = null
        val value:String = binding.registerEtEmail.text.toString()
        if(value.isEmpty()){
            errorMessage = "Email is Required"
            binding.registerEtEmail.requestFocus()
        }
        if (errorMessage != null){
            binding.editProTextInputEmail.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null

    }*/

    /** emailValidation */
    /*private fun emailFocusListener() {
        binding.registerEtEmail.setOnFocusChangeListener{ _,focused->
            if (!focused){
                binding.editProTextInputEmail.helperText = validEmail()
            }
        }
    }*/
    /*private fun validEmail(): String? {
        val emailText = binding.registerEtEmail.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()){
            return "Invalid Email Address"
        }
        return null
    }*/
    /** passwordValidation */
   /* private fun passwordFocusListener() {
        binding.registerEtPass.setOnFocusChangeListener{ _,focused->
            if (!focused){
                binding.editProTextInputPassword.helperText = validPassword()
            }
        }
    }*/
    /*private fun validPassword(): String? {
        val passwordText = binding.registerEtPass.text.toString()
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