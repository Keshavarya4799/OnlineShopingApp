package com.karya.onlineshoping.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.karya.onlineshoping.R
import com.karya.onlineshoping.databinding.FragmentOfferManagementBinding


class OfferManagement : Fragment(R.layout.fragment_offer_management) {
    lateinit var binding: FragmentOfferManagementBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_offer_management, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentOfferManagementBinding.bind(view)
    }


}