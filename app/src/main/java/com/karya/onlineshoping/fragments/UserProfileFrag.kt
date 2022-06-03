package com.karya.onlineshoping.fragments
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.karya.onlineshoping.R
import com.karya.onlineshoping.activities.LoginActivity
import com.karya.onlineshoping.databinding.FragmentUserProfileBinding

class UserProfileFrag : Fragment(R.layout.fragment_user_profile) {

    lateinit var binding : FragmentUserProfileBinding
    lateinit var firebaseAuth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUserProfileBinding.bind(view)
        firebaseAuth = FirebaseAuth.getInstance()
        onClicks()

        /** From Fragment to Activity by Just Click on LogOut from User Profile Frag.*/
        /*binding.userTvInCardViewLogOut.setOnClickListener {
            val intent = Intent(context?.applicationContext,BuyProducts::class.java)
            context?.startActivity(Intent(intent))
        }

        activity?.let{
            val intent = Intent (it, MainActivity::class.java)
            it.startActivity(intent)
        }*/

    }

    private fun onClicks() {
        binding.userCardViewOrderMgt.setOnClickListener {
            findNavController().navigate(R.id.action_userProfileFrag_to_orderManagementFrag)
        }
        binding.userCardViewOfferMgt.setOnClickListener {
            findNavController().navigate(R.id.action_userProfileFrag_to_offerManagement)
        }
        binding.editProfileFrag.setOnClickListener {
            findNavController().navigate(R.id.action_userProfileFrag_to_editProfileFrag)

        }
        binding.userCardViewLogOut.setOnClickListener {
            Toast.makeText(context?.applicationContext,"Logged Out",Toast.LENGTH_SHORT).show()
            firebaseAuth.signOut()
            findNavController().navigate(R.id.action_userProfileFrag_to_loginFrag2)
            //val intent = Intent(context?.applicationContext,LoginActivity::class.java)
            //startActivity(intent)
        }
        binding.userCardViewSettings.setOnClickListener {
            findNavController().navigate(R.id.action_userProfileFrag_to_settingsFrag)
        }
    }
}
