package com.karya.onlineshoping.activities

import android.app.Activity
import android.content.res.ColorStateList.valueOf
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.karya.onlineshoping.R
import com.karya.onlineshoping.databinding.ActivityBuyProductsBinding

class BuyProducts : AppCompatActivity() {

    lateinit var binding: ActivityBuyProductsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBuyProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.title = "Buy Product"

        /** Call/Get the RecyclerView data here(in Activity) from Adapter Class.*/

        val productData = intent
        val productImage = productData.getIntExtra("productImage", 0)
        val productName = productData.getStringExtra("productName")
        val productPrice = productData.getStringExtra("productPrice")
        val productDescription = productData.getStringExtra("productDescription")
        binding.purchaseIvProduct.setImageResource(productImage)
        binding.purchaseTvProductName.text = productName
        binding.purchaseTvProductPrice.text = productPrice
      binding.purchaseTvProductDetail.text = productDescription

    }
}