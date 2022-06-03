package com.karya.onlineshoping.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.karya.onlineshoping.R
import com.karya.onlineshoping.databinding.FragmentPaymentGateWayBinding

class PaymentGateWay : Fragment(R.layout.fragment_payment_gate_way) {

    private lateinit var binding: FragmentPaymentGateWayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentPaymentGateWayBinding.inflate(layoutInflater)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment_gate_way, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPaymentGateWayBinding.bind(view)
    }


}