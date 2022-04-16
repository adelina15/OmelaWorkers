package com.example.omelaworkers.viewmodel

import androidx.lifecycle.*
import com.example.omelaworkers.data.model.OrdersItem
import com.example.omelaworkers.data.repository.Repository
import kotlinx.coroutines.launch

class ActiveOrdersViewModel (private val repository: Repository): ViewModel(),
    DefaultLifecycleObserver {

    val activeOrdersLiveData = MutableLiveData<ArrayList<OrdersItem>>()

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        getOrders()
        getGoOrders()
        getGetOrders()
        getHereOrders()
    }

    fun getOrders() {
        viewModelScope.launch {
            val response = repository.getActiveOrders()
            if (response.isSuccessful){
                activeOrdersLiveData.postValue(response.body())
            }
        }
    }

    fun getGoOrders() {
        viewModelScope.launch {
            val response = repository.getGoOrders()
            if (response.isSuccessful){
                activeOrdersLiveData.postValue(response.body())
            }
        }
    }

    fun getHereOrders() {
        viewModelScope.launch {
            val response = repository.getHereOrders()
            if (response.isSuccessful){
                activeOrdersLiveData.postValue(response.body())
            }
        }
    }

    fun getGetOrders() {
        viewModelScope.launch {
            val response = repository.getGetOrders()
            if (response.isSuccessful){
                activeOrdersLiveData.postValue(response.body())
            }
        }
    }
}