package com.example.omelaworkers.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewOrder (
    val client_name: String,
    val client_number: String,
    val client_address: String,
    val branch_address: String,
    val order_time: String
        ): Parcelable