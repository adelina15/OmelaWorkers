package com.example.omelaworkers.data.repository

import com.auth0.android.jwt.JWT
import com.example.omelaworkers.data.Api
import com.example.omelaworkers.data.model.*
import org.json.JSONObject
import retrofit2.Response

class Repository constructor(private val api: Api) {

    suspend fun getActiveOrders(): Response<ArrayList<OrdersItem>>{
        return api.getActiveOrders()
    }

    suspend fun getGoOrders(): Response<ArrayList<OrdersItem>>{
        return api.getGoOrders()
    }

    suspend fun getGetOrders(): Response<ArrayList<OrdersItem>>{
        return api.getGetOrder()
    }

    suspend fun getHereOrders(): Response<ArrayList<OrdersItem>>{
        return api.getHereOrders()
    }

    suspend fun getDoneOrders(): Response<ArrayList<OrdersItem>>{
        return api.getDoneOrders()
    }

    suspend fun getNewOrders(): Response<ArrayList<OrdersItem>>{
        return api.getNewOrders()
    }

    suspend fun getToken(number: String, password: String): Response<Worker> {
        return api.getWorker(number, password)
    }

    suspend fun getFlowers(): Response<ArrayList<Flower>>{
        return api.getFlowers()
    }

    fun changeStatus(id: Int?, status: String): Response<OrdersItem>{
        return api.changeStatus(id, status)
    }
}