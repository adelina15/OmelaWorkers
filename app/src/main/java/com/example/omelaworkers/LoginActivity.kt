package com.example.omelaworkers

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.example.omelaworkers.courier.CourierActivity
import com.example.omelaworkers.databinding.ActivityLoginBinding
import com.example.omelaworkers.florist.FloristActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    var isNumberCorrect = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        //Make status bar white
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val window: Window = window
            val decorView: View = window.decorView
            val wic = WindowInsetsControllerCompat(window, decorView)
            wic.isAppearanceLightStatusBars = true
            window.statusBarColor = Color.WHITE
        }
        binding.show.setOnClickListener { showHidePass(binding.show, binding.registrationPassword) }
        binding.verifyButton.setOnClickListener {
//            if (binding.editTextPhone.length() == 13 && binding.registrationPassword.text.isNotEmpty()){
//                startActivity(Intent(this, CourierActivity::class.java))
//            }
            if (binding.editTextPhone.text.toString() == "+996700559950"){
                startActivity(Intent(this, FloristActivity::class.java))
            }
            if (binding.editTextPhone.text.toString() == "+996707559950"){
                startActivity(Intent(this, CourierActivity::class.java))
            }
        }
    }

    private fun showHidePass(view: ImageView, editText: EditText){
        if (view.tag == "R.id.ic_visible") {
            editText.transformationMethod = HideReturnsTransformationMethod.getInstance()
            view.setImageResource(R.drawable.ic_visibility)
            view.tag = "R.drawable.ic_visibility"
        } else {
            editText.transformationMethod = PasswordTransformationMethod.getInstance()
            view.setImageResource(R.drawable.ic_visible)
            view.tag = "R.id.ic_visible"
        }
    }

}