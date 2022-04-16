package com.example.omelaworkers.viewmodel

import androidx.lifecycle.*
import com.example.omelaworkers.data.model.OrdersItem
import com.example.omelaworkers.data.repository.Repository
import kotlinx.coroutines.launch

class FinishedOrdersViewModel (private val repository: Repository): ViewModel(),
    DefaultLifecycleObserver {

    val finishedOrdersLiveData = MutableLiveData<ArrayList<OrdersItem>>()

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        getOrders()
    }

    fun getOrders() {
        viewModelScope.launch {
            val response = repository.getDoneOrders()
            if (response.isSuccessful){
                finishedOrdersLiveData.postValue(response.body())
            }
        }
    }
}