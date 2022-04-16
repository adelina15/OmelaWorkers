package com.example.omelaworkers.viewmodel

import androidx.lifecycle.*
import com.example.omelaworkers.data.model.Flower
import com.example.omelaworkers.data.model.OrdersItem
import com.example.omelaworkers.data.repository.Repository
import kotlinx.coroutines.launch

class FlowersViewModel(private val repository: Repository): ViewModel(), DefaultLifecycleObserver {

    val flowersLiveData = MutableLiveData<ArrayList<Flower>>()

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        getFlowers()
    }

    fun getFlowers() {
        viewModelScope.launch {
            val response = repository.getFlowers()
            if (response.isSuccessful) {
                flowersLiveData.postValue(response.body())
            }
        }
    }
}