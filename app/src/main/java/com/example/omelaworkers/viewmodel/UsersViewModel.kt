package com.example.omelaworkers.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.auth0.android.jwt.JWT
import com.example.omelaworkers.data.model.Worker
import com.example.omelaworkers.data.repository.Repository
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject

class UsersViewModel(private val repository: Repository) : ViewModel(), DefaultLifecycleObserver {

    var worker = MutableLiveData<Worker>()
    var errorMessage = MutableLiveData<String>()

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
    }

    fun getWorker(number: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val request = repository.getToken(number, password)
            if (request.isSuccessful) {
                worker.postValue(request.body())
            } else {
                errorMessage.postValue(request.errorBody().toString())
            }
        }
    }

}