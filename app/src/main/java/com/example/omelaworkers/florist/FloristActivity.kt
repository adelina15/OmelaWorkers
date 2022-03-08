package com.example.omelaworkers.florist

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.annotation.RequiresApi
import androidx.core.view.WindowInsetsControllerCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.omelaworkers.R
import com.example.omelaworkers.databinding.ActivityFloristBinding

class FloristActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFloristBinding
    private lateinit var navController: NavController

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_florist)

        val bottomNavigationView = binding.floristBottomNavigationView
        navController = findNavController(R.id.florist_nav_fragment)
        bottomNavigationView.setupWithNavController(navController)
        bottomNavigationView.itemIconTintList = null;


        //Make status bar white
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val window: Window = window
            val decorView: View = window.decorView
            val wic = WindowInsetsControllerCompat(window, decorView)
            wic.isAppearanceLightStatusBars = true
            window.statusBarColor = Color.WHITE
        }
    }
}