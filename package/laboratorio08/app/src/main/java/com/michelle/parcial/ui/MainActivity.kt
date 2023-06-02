package com.michelle.parcial.ui

import com.michelle.parcial.R


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.michelle.parcial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}