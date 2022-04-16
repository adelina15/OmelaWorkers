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
import com.example.omelaworkers.data.UserPreferences
import com.example.omelaworkers.databinding.ActivityLoginBinding
import com.example.omelaworkers.utils.Roles
import com.example.omelaworkers.view.courier.CourierActivity
import com.example.omelaworkers.view.florist.FloristActivity
import com.example.omelaworkers.viewmodel.UsersViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val userViewModel by viewModel<UsersViewModel>()
    lateinit var sharedPreferences: UserPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.show.setOnClickListener { showHidePass(binding.show, binding.registrationPassword) }
        binding.verifyButton.setOnClickListener {
            getWorker(binding.editTextPhone.text.toString(), binding.registrationPassword.text.toString())
        }
        sharedPreferences =  UserPreferences(this)

    }

    //get token and get role from it to open relevant activity
    private fun getWorker(number: String, password: String) {
        userViewModel.getWorker(number, password)
        userViewModel.worker.observe(this){
            sharedPreferences.saveUserNumber(number)
            sharedPreferences.saveUserName(it.name)
            sharedPreferences.saveUserPhoto(it.image)
            when (it.role) {
                Roles.COURIER.role -> {
                    val intent = Intent(this, CourierActivity::class.java)
                    startActivity(intent)
                }
                Roles.FLORIST.role -> {
                    val intent = Intent(this, FloristActivity::class.java)
                    startActivity(intent)
                }
            }
        }
        userViewModel.errorMessage.observe(this){
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

    //shows and hides password
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