package com.example.omelaworkers.data

import com.auth0.android.jwt.JWT
import com.example.omelaworkers.data.model.OrdersItem
import com.example.omelaworkers.data.model.Token
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @GET("order")
    suspend fun getAllOrders(): Response<ArrayList<OrdersItem>>

    @FormUrlEncoded
    @POST("auth/login/user")
    suspend fun getToken(
        @Field("phoneNumber") phoneNumber: String,
        @Field("password") password: String
    ): Response<Token>
}