package com.karya.onlineshoping.fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.karya.onlineshoping.R
import com.karya.onlineshoping.databinding.FragmentPurchaseProductBinding

class PurchaseProductFrag : Fragment(R.layout.fragment_purchase_product) {

    private lateinit var binding: FragmentPurchaseProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentPurchaseProductBinding.inflate(layoutInflater)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        /** Call/Get the RecyclerView data here(in Fragment) from Adapter Class.*/

        val bundle = Bundle()
            val productImage = bundle.getInt("productImage", 0)
            val productName = bundle.getString("productName")
            val productPrice = bundle.getString("productPrice")
            val productDescription = bundle.getString("productDescription")

            binding.purchaseIvProduct.setImageResource(productImage)
            binding.purchaseTvProductName.text = productName
            binding.purchaseTvProductPrice.text = productPrice
            binding.purchaseTvProductDetail.text = productDescription

        return inflater.inflate(R.layout.fragment_purchase_product, container, false)
    }

    @SuppressLint("InflateParams")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPurchaseProductBinding.bind(view)

        /** Btn Add Item to Wish List Wish List */
        binding.floatingBtnAddToWishList.setOnClickListener {
            binding.floatingBtnAddToWishList.imageTintList =
                ColorStateList.valueOf(Color.rgb(245, 0, 0))
            Toast.makeText(context, "Item Added Successfully", Toast.LENGTH_SHORT).show()

        }
        /** BottomSheetDialog */
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        val view = layoutInflater.inflate(R.layout.fragment_buy_product_bottom_sheet, null)
        bottomSheetDialog.setContentView(view)

        // bottomSheetDialog.show() shows Automatically when PurchaseProductFrag Open.

        binding.btnBuyProduct.setOnClickListener {
            findNavController().navigate(R.id.action_purchaseProductFrag_to_buyProductBottomSheet)

        }

        /** Drop Down Menu Items For Size */
        ArrayAdapter.createFromResource(
            requireContext(), R.array.Size, android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
            // Apply the adapter to the spinner
            binding.dropdownMenu.adapter = adapter
        }
        class SpinnerActivity : Activity(), AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
                TODO("Not yet implemented")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        // Open Deep Link by Just Click on Btn.
        /** binding.btnBuyProduct.setOnClickListener {
        val openURL = Intent(android.content.Intent.ACTION_VIEW)
        openURL.data = Uri.parse("https://www.google.com/")
        startActivity(openURL)

        binding.btnAddToCart.setOnClickListener {
        val openURL = Intent(android.content.Intent.ACTION_VIEW)
        openURL.data = Uri.parse("https://www.tutorialkart.com/")
        startActivity(openURL)
        }
        } */

    }
}