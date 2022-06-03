package com.karya.onlineshoping.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.karya.onlineshoping.R
import com.karya.onlineshoping.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity(R.layout.activity_registration) {
    lateinit var binding:ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}