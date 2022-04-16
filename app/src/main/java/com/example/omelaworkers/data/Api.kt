package com.example.omelaworkers.data

import com.example.omelaworkers.data.model.Flower
import com.example.omelaworkers.data.model.OrdersItem
import com.example.omelaworkers.data.model.Worker
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.*

interface Api {


    @GET("orders?status=CALL_WAITING")
    suspend fun getNewOrders(): Response<ArrayList<OrdersItem>>

    @GET("orders?status=COURIER_TAKE_ORDER")
    suspend fun getActiveOrders(): Response<ArrayList<OrdersItem>>

    @GET("orders?status=COURIER_GET_ORDER")
    suspend fun getGetOrder(): Response<ArrayList<OrdersItem>>

    @GET("orders?status=COURIER_GO")
    suspend fun getGoOrders(): Response<ArrayList<OrdersItem>>

    @GET("order/orders?status=COURIER_HERE")
    suspend fun getHereOrders(): Response<ArrayList<OrdersItem>>

    @GET("order/orders?status=DONE")
    suspend fun getDoneOrders(): Response<ArrayList<OrdersItem>>

    @FormUrlEncoded
    @POST("users/auth")
    suspend fun getWorker(
        @Field("phoneNumber") phoneNumber: String,
        @Field("password") password: String
    ): Response<Worker>

    @FormUrlEncoded
    @PATCH("orders/{id}")
    fun changeStatus(
        @Path("id") id: Int?,
        @Field("status") status: String
    ): Response<OrdersItem>

    @GET("flowers?%D0%A2%D0%B8%D0%BF%20%D0%BE%D1%82%D0%B2%D0%B5%D1%82%D0%B0=AVAILABLE")
    suspend fun getFlowers(): Response<ArrayList<Flower>>
}