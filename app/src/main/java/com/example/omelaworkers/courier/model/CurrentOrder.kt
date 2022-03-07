package com.example.omelaworkers.courier.model

data class CurrentOrder (
    val client_name: String,
    val client_number: String,
    val client_address: String,
    val branch_address: String,
    val order_time: String,
    var order_status: String = "принял"
    )