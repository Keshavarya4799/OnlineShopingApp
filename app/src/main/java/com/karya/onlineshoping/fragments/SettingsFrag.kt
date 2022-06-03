package com.karya.onlineshoping.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.karya.onlineshoping.R
import com.karya.onlineshoping.databinding.FragmentSettingsBinding


class SettingsFrag : Fragment(R.layout.fragment_settings) {
    private lateinit var binding: FragmentSettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentSettingsBinding.inflate(layoutInflater)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)

        binding.settingBtnLogOut.setOnClickListener {
            Toast.makeText(context,"Logged Out",Toast.LENGTH_SHORT).show()
        }
        binding.settingCardViewLang.setOnClickListener {
            Toast.makeText(context,"Select Language",Toast.LENGTH_SHORT).show()
        }
        binding.settingCardViewCountry.setOnClickListener {
            Toast.makeText(context,"Select Country",Toast.LENGTH_SHORT).show()
        }
        binding.settingCardViewCurrency.setOnClickListener {
            Toast.makeText(context,"Select Currency",Toast.LENGTH_SHORT).show()
        }
        binding.settingCardViewNoti.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFrag_to_notificationFrag)
        }
        binding.settingCardViewChangePass.setOnClickListener {
            Toast.makeText(context,"Change Password",Toast.LENGTH_SHORT).show()
        }
        binding.settingCardViewPrivacyPolicy.setOnClickListener {
            Toast.makeText(context,"Manage Privacy Policies",Toast.LENGTH_SHORT).show()
        }

    }


}