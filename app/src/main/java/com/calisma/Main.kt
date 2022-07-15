package com.calisma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.calisma.databinding.ActivityMainBinding


class Main : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navigation = supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
        NavigationUI.setupWithNavController(binding.navbottom,navigation.navController)

    }
}