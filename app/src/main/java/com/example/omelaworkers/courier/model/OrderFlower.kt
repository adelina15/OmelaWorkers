package com.example.omelaworkers.courier.model

data class OrderFlower (
    val name: String,
    val image: Int,
    val price: Int,
    val discount: Int? = null,
)