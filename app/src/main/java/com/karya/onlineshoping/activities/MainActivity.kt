package com.karya.onlineshoping.activities
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.karya.onlineshoping.R
import com.karya.onlineshoping.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var toggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /** Bottom Navigation */
        val navHostFragment =
            supportFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment?

        if (navHostFragment != null) {
            navController = navHostFragment.navController
            binding.bottomNavView.setupWithNavController(navController)
        }

         /** Hide and Show Bottom Navigation View. */
        navController.addOnDestinationChangedListener { _, nd: NavDestination, _ ->
            if (nd.id == R.id.homeFrag) {
                binding.bottomNavView.visibility = View.VISIBLE
            } else {
                binding.bottomNavView.visibility = View.GONE
            }
        }
        /** Hide and Show supportActionBar */
        navController.addOnDestinationChangedListener { _, nd: NavDestination, _ ->
            if (nd.id == R.id.loginFrag2  || nd.id == R.id.registerFrag) {
                (this as AppCompatActivity?)!!.supportActionBar?.hide()
            } else {
                (this as AppCompatActivity?)!!.supportActionBar?.show()
            }
        }

        binding.navigationView.setNavigationItemSelectedListener{
            it.isChecked = true
            when(it.itemId){
                R.id.miShare->{
                    Toast.makeText(applicationContext,"Clicked",Toast.LENGTH_SHORT).show()
                    Log.d("ok","Clicked")
                }
            }
            true
        }

       /* val inflater = navHostFragment?.navController?.navInflater
        val graph = inflater?.inflate(R.navigation.nav_graph)
        graph?.setStartDestination(R.id.loginFrag2)
        navHostFragment?.navController?.graph*/

        /** Navigation Up Button */
        appBarConfiguration = AppBarConfiguration(navController.graph, binding.drawerLayout)
        NavigationUI.setupActionBarWithNavController(this,navController)
        NavigationUI.setupWithNavController(binding.navigationView, navController)

        /** Drawer Layout Menu Items */
        /*toggle = ActionBarDrawerToggle(this,binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)*/

    }
    override fun onSupportNavigateUp(): Boolean {
        return when(navController.currentDestination?.id){
            R.id.homeFrag->{
                (this as AppCompatActivity?)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true)
                finish()
                return true
            }
            else-> {
                navController.navigateUp()
            }
        }
    }
}