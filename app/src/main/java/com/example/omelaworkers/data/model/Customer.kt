package com.example.omelaworkers.data.model

import java.io.Serializable

data class Customer(
    val id: Int,
    val image: String,
    val name: String,
    val password: String,
    val phoneNumber: String,
    val role: String,
    val surname: String
): Serializable