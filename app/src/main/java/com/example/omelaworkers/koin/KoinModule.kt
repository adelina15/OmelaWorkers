package com.example.omelaworkers.koin

import com.example.omelaworkers.utils.Constants
import com.example.omelaworkers.data.Api
import com.example.omelaworkers.data.repository.Repository
import com.example.omelaworkers.viewmodel.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val retrofitModule = module {

    single { getOkHttp() }
    single { getRetrofitInstance(okHttpClient = get()) }
    single { getProductApi(retrofit = get()) }
    factory { Repository(api = get()) }
}

val viewModules = module {
    viewModel { NewOrdersViewModel(repository = get()) }
    viewModel { UsersViewModel(repository = get()) }
    viewModel { ActiveOrdersViewModel(repository = get()) }
    viewModel { FinishedOrdersViewModel(repository = get()) }
    viewModel { FlowersViewModel(repository = get()) }
}

fun getOkHttp(): OkHttpClient {
    return OkHttpClient.Builder()
        .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .build()
}

fun getProductApi(retrofit: Retrofit): Api {
    return retrofit.create(Api::class.java)
}

fun getRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}