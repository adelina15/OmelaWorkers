package com.example.omelaworkers.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.auth0.android.jwt.JWT
import com.example.omelaworkers.data.model.Token
import com.example.omelaworkers.data.model.UserItem
import com.example.omelaworkers.data.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject

class UsersViewModel(private val repository: Repository) : ViewModel(), DefaultLifecycleObserver {

    var tokens = MutableLiveData<Token>()
//    val userLiveData = MutableLiveData<ArrayList<UserItem>>()

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)

    }

    fun getToken(number: String, uid: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val request = repository.getToken(number, uid)
            if (request.isSuccessful) {
                tokens.postValue(request.body())
            } else {
                request.errorBody()
                Log.i("error", "${request.errorBody()}" )
            }
        }
    }

//    fun getUsers() {
//        viewModelScope.launch {
//            val response = repository.getAllUsers()
//            if (response.isSuccessful) {
//                userLiveData.postValue(response.body())
//            }
//        }
//    }
}