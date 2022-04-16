package com.example.omelaworkers.data.model

import java.io.Serializable

data class Bouquet (
    val createdAt: String,
    val description: String,
    val discount: Int,
    val discountResult: Int? = null,
    val id: Int,
    val name: String,
    val photo: String,
    val price: String,
): Serializable