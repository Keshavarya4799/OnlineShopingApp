package com.karya.onlineshoping.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.karya.onlineshoping.R
import com.karya.onlineshoping.adapter.RecyclerItemAdapter
import com.karya.onlineshoping.databinding.FragmentHomeBinding
import com.karya.onlineshoping.model.RecyclerItemModel
import java.util.*

class HomeFrag : Fragment(R.layout.fragment_home) {

    lateinit var binding: FragmentHomeBinding
    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var newArrayList: ArrayList<RecyclerItemModel>
    private lateinit var displayList: ArrayList<RecyclerItemModel>
    private lateinit var imageList: ArrayList<SlideModel>
    private lateinit var pic: Array<Int>
    private lateinit var text1: Array<String>
    private lateinit var text2: Array<String>
    private lateinit var text3: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /** setHasOptionsMenu for Menu Items Visibility on Toolbar */
        //  setMenuVisibility(true)  // this is for Activity
        setHasOptionsMenu(true)   // this is for Fragment

        binding = FragmentHomeBinding.inflate(layoutInflater) // This is for inflate RecyclerView
        binding.recyclerView.setHasFixedSize(true)

        /** Recycler View Items Data */
        pic = arrayOf(
            R.drawable.onlinerecycleritemimg1,
            R.drawable.onlinerecycleritemimg2,
            R.drawable.onlinerecycleritemimg3,
            R.drawable.onlinerecycleritemimg4,
            R.drawable.onlinerecycleritemimg5,
            R.drawable.onlinerecycleritemimg6,
            R.drawable.onlinerecycleritemimg7,
            R.drawable.onlinerecycleritemimg8,
            R.drawable.onlinerecycleritemimg9
        )
        text1 = arrayOf(
            "White t-Shirt",
            "t-Shirts",
            "Combo t-Shits",
            "Clothes",
            "Combo Items",
            "Fair Clothes",
            "Colorful Shirts Combo",
            "Shirts Pack",
            "Trio Shirts"
        )
        text2 = arrayOf(
            "$3", "$2", "$5", "$3", "$2", "$6", "$8", "$5", "$6"
        )
        text3 = arrayOf(
            "Calvin Klein Men’s 1/4 Zip Sweater” is not enough to tell the customers about the product",
            "Scott International Multi Color Cotton T-shirt Men",
            "Galatea Cotton Polo T-shirt--Blue",
            "Scott International Multi Color Cotton T-shirt Men",
            "AWG Men's Dry-fit Polyester Round Neck Half Sleeve T-shirts - Pack of 3",
            "AWG Men's Dry-fit Polyester Round Neck Half Sleeve T-shirts - Pack of 3",
            "Scott International Multi Color Cotton T-shirt Men",
            "AWG - All Weather Gear Men's Regular Fit Solid T-Shirt - White",
            "AWG Men's Dry-fit Polyester Round Neck Half Sleeve T-shirts - Pack of 3"
        )
        // newArrayList.add(RecyclerItemModel(R.drawable.onlineRecyclerItemImg1,"White t-Shirt","$4"))

        /** Initializing newArrayList and displayList */
        // With Assignment Expression
        arrayListOf<RecyclerItemModel>().also { newArrayList = it }
        arrayListOf<RecyclerItemModel>().also { displayList = it }
        //WithOut Assignment Expression
        //displayList = arrayListOf<RecyclerItemModel>()
        //newArrayList = arrayListOf<RecyclerItemModel>()




        getUserData()
    }

    private fun getUserData() {
        for (i in pic.indices) {
            val recyclerItemModel = RecyclerItemModel(pic[i], text1[i], text2[i], text3[i])
            newArrayList.add(recyclerItemModel)
            //displayList.add(recyclerItemModel) /** if we get displayList data Here too, recycler data will get double*/
        }
        /* In Activity Set here the LayoutManager and Adapter With Recycler View [See-> Project: InsKotlin]
             binding.recyclerView.adapter = recyclerItemAdapter(newArrayList) */
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentHomeBinding.bind(view)
        // In Fragments Set here the LayoutManager and Adapter With Recycler View


        /** Image Slider */
        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel( R.drawable.onlinerecycleritemimg1,"Premium Polyester T-shirt"))
        imageList.add(SlideModel( R.drawable.onlinerecycleritemimg9,"Urbane Retro Men T-shirt"))
        imageList.add(SlideModel(R.drawable.onlinerecycleritemimg3,"Fancy Elegant Men T-shirt"))
        imageList.add(SlideModel(R.drawable.onlinerecycleritemimg7,"Party Wear Men T-shirts"))
        binding.imageSlider.setImageList(imageList, ScaleTypes.FIT)

        binding.recyclerView.apply {

            layoutManager = GridLayoutManager(context?.applicationContext, 2, LinearLayoutManager.VERTICAL, false)  // For GridLayout.
            //adapter = RecyclerItemAdapter(context,newArrayList) // Till Here WithOut SearchView

            /** With SearchView */
            adapter = RecyclerItemAdapter(context, displayList)
            binding.recyclerView.itemAnimator
            displayList.addAll(newArrayList)

        }
    }

    /** Search View */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_view, menu)   // In Activity Use menuInflater instead of inflater
        val menuItem = menu.findItem(R.id.searchView)

        if (menuItem != null) {
            val searchView = menuItem.actionView as SearchView
            searchView.queryHint = "Search by Product Name"
            searchView.setBackgroundColor(Color.GRAY)
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {

                    return true
                }
                @SuppressLint("NotifyDataSetChanged")
                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText!!.isNotEmpty()) {
                        //binding.imageSlider.visibility = View.INVISIBLE
                        displayList.clear()

                        val searchView = newText.lowercase(Locale.getDefault())

                        newArrayList.forEach {
                            if (it.productName.lowercase(Locale.getDefault())
                                    .contains(searchView)
                            ) {
                                displayList.add(it)
                            }
                        }
                        binding.recyclerView.adapter?.notifyDataSetChanged()

                    } else {
                        displayList.clear()
                        displayList.addAll(newArrayList)
                        binding.recyclerView.adapter?.notifyDataSetChanged()
                    }
                    return true
                }
            })
        }
        return super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onPause() {
        super.onPause()
        Log.i("Home", "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Home", "onStop: ")
        /* RecyclerItem Data  of HomeFrag Getting Double when return from Another Fragment So We
         Clear The Data of HomeFrag When Fragment is in its Stop State(in Another Fragment or Activity) */
        displayList.clear()
    }

}
