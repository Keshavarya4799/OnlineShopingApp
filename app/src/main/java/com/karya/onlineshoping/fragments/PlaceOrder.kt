package com.karya.onlineshoping.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.karya.onlineshoping.R
import com.karya.onlineshoping.databinding.FragmentBuyProductBottomSheetBinding
import com.karya.onlineshoping.databinding.FragmentPlaceOrderBinding


class PlaceOrder : Fragment(R.layout.fragment_place_order) {

    private lateinit var binding:FragmentPlaceOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentPlaceOrderBinding.inflate(layoutInflater)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_place_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPlaceOrderBinding.bind(view)
    }


}