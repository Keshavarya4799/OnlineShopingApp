package com.karya.onlineshoping.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.karya.onlineshoping.R
import com.karya.onlineshoping.activities.BuyProducts
import com.karya.onlineshoping.fragments.PurchaseProductFrag
import com.karya.onlineshoping.model.RecyclerItemModel

class RecyclerItemAdapter(
    private val c: Context,
    private val productList: ArrayList<RecyclerItemModel>,
) : RecyclerView.Adapter<RecyclerItemAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItems = productList[position]
        holder.productImg.setImageResource(currentItems.productImg)
        holder.productName.text = currentItems.productName
        holder.productPrice.text = currentItems.productPrice
        holder.productDescription.text = currentItems.productDescription


        /** Recycler View on ItemClick.*/
        holder.itemView.setOnClickListener {
            //Toast.makeText(c,"${holder.productName} is Product Name",Toast.LENGTH_SHORT).show()  // This is for check OnClick.
            val productImage: Int = currentItems.productImg
            val productName: String = currentItems.productName
            val productPrice: String = currentItems.productPrice
            val productDescription: String = currentItems.productDescription

            /** This is for Sending Data from Adapter to Activity Via Intent. */
            /*val itemIntent = Intent(c, BuyProducts::class.java)
            itemIntent.putExtra("productImage",productImage)  // This  putExtra Name [productImage] should be same as getStringExtra Name
            itemIntent.putExtra("productName",productName)
            itemIntent.putExtra("productPrice",productPrice)
            itemIntent.putExtra("productDescription", productDescription)
            c.startActivity(itemIntent)*/

            /** This is for Sending Data from Adapter to Fragment Via Bundle */
            val bundle = Bundle()
            val purchaseProductFrag = PurchaseProductFrag()
            val navController = it.findNavController()
            navController.navigate(R.id.purchaseProductFrag)
            bundle.putInt(
                "productImage",
                productImage
            )  // This  putINt Name [productImage] should be same as getStringExtra Name
            bundle.putString("productName", productName)
            bundle.putString("productPrice", productPrice)
            bundle.putString("productDescription", productDescription)
            purchaseProductFrag.arguments = bundle

        }
    }

    override fun getItemCount(): Int {
        return productList.size  // here productList is the private val which we defined above under class RecyclerItemAdapter.
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //bind RecyclerView Items
        val productImg: ImageView = itemView.findViewById(R.id.recyclerImg)
        val productName: TextView = itemView.findViewById(R.id.recyclerText1)
        val productPrice: TextView = itemView.findViewById(R.id.recyclerText2)
        val productDescription: TextView = itemView.findViewById(R.id.recyclerText3)

    }
}