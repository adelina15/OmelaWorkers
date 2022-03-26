package com.example.omelaworkers.data.repository

import com.auth0.android.jwt.JWT
import com.example.omelaworkers.data.Api
import com.example.omelaworkers.data.model.OrdersItem
import com.example.omelaworkers.data.model.Token
import com.example.omelaworkers.data.model.UserItem
import org.json.JSONObject
import retrofit2.Response

class Repository constructor(private val api: Api) {
    suspend fun getAllOrders(): Response<ArrayList<OrdersItem>> {
        return api.getAllOrders()
    }

    suspend fun getToken(number: String, uid: String): Response<Token> {
        return api.getToken(number, uid)
    }
}