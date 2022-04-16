package com.example.omelaworkers.data.model

import java.io.Serializable

data class OrdersItem(
    val address: String,
    val bouquets: List<Bouquet>,
    val customer: Customer,
    val customerMoney: Int,
    val customerName: String,
    val id: Int,
    val orderDate: String,
    val status: String,
    val suggestion: String,
    val totalSum: Int
): Serializable
