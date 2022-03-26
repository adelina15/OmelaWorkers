package com.example.omelaworkers.view

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
import androidx.core.view.WindowInsetsControllerCompat
import androidx.databinding.DataBindingUtil
import com.auth0.android.jwt.Claim
import com.auth0.android.jwt.JWT
import com.example.omelaworkers.R
import com.example.omelaworkers.databinding.ActivityLoginBinding
import com.example.omelaworkers.view.courier.CourierActivity
import com.example.omelaworkers.view.florist.FloristActivity
import com.example.omelaworkers.viewmodel.UsersViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val userViewModel by viewModel<UsersViewModel>()
    lateinit var str: String

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
            getToken(binding.editTextPhone.text.toString(), binding.registrationPassword.text.toString())
        }
    }

    private fun getToken(number: String, password: String) {
        userViewModel.getToken(number, password)
        userViewModel.tokens.observe(this){
            val token: String = it.token
            val jwt = JWT(token)
            val claim: Claim = jwt.getClaim("role")
            when (claim.asString().toString()) {
                "Курьер" -> {
                    val intent = Intent(this, CourierActivity::class.java)
                    startActivity(intent)
                }
                "Флорист" -> {
                    val intent = Intent(this, FloristActivity::class.java)
                    startActivity(intent)
                }
//                else -> Toast.makeText(this, "ghghgh", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showHidePass(view: ImageView, editText: EditText) {
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