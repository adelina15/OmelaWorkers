package com.example.omelaworkers.data

import android.content.Context
import android.content.SharedPreferences
import com.example.omelaworkers.utils.Constants

class UserPreferences(context: Context){
    private val prefs: SharedPreferences =
        context.getSharedPreferences("TestApp", Context.MODE_PRIVATE)
    private val editor = prefs.edit()

    fun delete(){
        editor.clear()
        editor.commit()
    }

    fun saveUserName(name: String?){
        if (name != null){
            editor.putString(Constants.NAME,name).apply()
        }
    }

    fun saveUserNumber(number: String?) {
        if (number != null) {
            editor.putString(Constants.NUMBER, number)
            editor.apply()
        }
    }

    fun saveUserPhoto(photo: String?) {
        if (photo != null) {
            editor.putString(Constants.PHOTO, photo)
            editor.apply()
        }
    }

    fun saveUserBranch(branch: String?) {
        if (branch != null) {
            editor.putString(Constants.BRANCH, branch)
            editor.apply()
        }
    }

    fun fetchUserPhoto():String? {
        return prefs.getString(Constants.PHOTO, null)
    }

    fun fetchUserName():String? {
        return prefs.getString(Constants.NAME, null)
    }

    fun fetchUserBranch():String? {
        return prefs.getString(Constants.BRANCH, null)
    }

    fun fetchUserNumber(): String? {
        return prefs.getString(Constants.NUMBER, null)
    }
}

