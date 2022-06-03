package com.karya.onlineshoping.bottomsheet

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.adapters.ToolbarBindingAdapter
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.karya.onlineshoping.R
import com.karya.onlineshoping.databinding.FragmentBuyProductBottomSheetBinding

class BuyProductBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding:FragmentBuyProductBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentBuyProductBottomSheetBinding.inflate(layoutInflater)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_buy_product_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBuyProductBottomSheetBinding.bind(view)


        /** Set OnClickListener */
        binding.btnSubmitDetails.setOnClickListener {
//            findNavController().navigate(R.id.action_buyProductBottomSheet_to_placeOrderFrag)

            binding.buyProBottomSheetEtFullName.editText?.setText("")
            binding.buyProBottomSheetEtContact.editText?.setText("")
            binding.buyProBottomSheetEtEmailIdContainer.editText?.setText("")
            binding.buyProBottomSheetEtCity.editText?.setText("")
            binding.buyProBottomSheetEtCountry.editText?.setText("")
            binding.buyProBottomSheetEtState.editText?.setText("")
            binding.buyProBottomSheetEtPinCode.editText?.setText("")
            Toast.makeText(context,"Form Submitted",Toast.LENGTH_SHORT).show()
            emailFocusListener()  // emailValidation

        }
    }

    /** emailValidation */
    private fun emailFocusListener() {
        binding.buyProBottomSheetEtEmailId.setOnFocusChangeListener{ _,focused->
            if (!focused){
                binding.buyProBottomSheetEtEmailIdContainer.helperText = validEmail()
            }
        }
    }
    private fun validEmail(): String? {
        val emailText = binding.buyProBottomSheetEtEmailId.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()){
            return "Invalid Email Address"
        }
            return null
    }
}