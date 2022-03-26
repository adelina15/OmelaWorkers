package com.example.omelaworkers.data.model

data class OrdersItem(
    val addInformation: String,
    val address: String,
    val bouquet: List<Any>,
    val buyerName: String,
    val buyerPhoneNumber: String,
    val date: String,
    val filial: String,
    val id: Int,
    val payment: String,
    val receiverName: String,
    val receiverPhoneNumber: String,
    val status: String
)
