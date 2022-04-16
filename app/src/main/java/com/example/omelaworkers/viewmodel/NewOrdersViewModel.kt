package com.example.omelaworkers.viewmodel

import androidx.lifecycle.*
import com.example.omelaworkers.data.model.OrdersItem
import com.example.omelaworkers.data.repository.Repository
import kotlinx.coroutines.launch

class NewOrdersViewModel (private val repository: Repository): ViewModel(), DefaultLifecycleObserver {

    val newOrdersLiveData = MutableLiveData<ArrayList<OrdersItem>>()

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        getOrders()
    }

    fun getOrders() {
        viewModelScope.launch {
            val response = repository.getNewOrders()
            if (response.isSuccessful){
                newOrdersLiveData.postValue(response.body())
            }
        }
    }

    fun changeStatus(id: Int?){
        val status = "COURIER_TAKE_ORDER"
        repository.changeStatus(id, status)
    }
}