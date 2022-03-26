package com.example.omelaworkers.data.model

data class OrderFlower (
    val name: String,
    val image: Int,
    val price: Int,
    val discount: Int? = null,
)