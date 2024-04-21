package com.example.workteams.authentication

import android.content.Context
import android.content.SharedPreferences
import com.example.workteams.R


object SessionManager {
    private const val USER_TOKEN = "user_token"
    private const val USER_NAME = "user_name"
    private val tokenTag = R.string.token_tag
    private val usernameTag = R.string.username_tag

    /*
    Function to save auth token
     */
    fun saveAuthToken(context: Context, token: String) {
        saveString(context, USER_TOKEN, token, tokenTag)
    }

    /*
    Function to save auth token
     */
    fun saveUsername(context: Context, username: String) {
        saveString(context, USER_NAME, username, usernameTag)
    }

//    fun saveUsernameString(context: Context, key: String, value: String) {
//        val prefs: SharedPreferences = context.getSharedPreferences(
//            context.getString(R.string.username_tag), Context.MODE_PRIVATE
//        )
//        val editor = prefs.edit()
//        editor.putString(key, value)
//        editor.apply()
//    }


    /*
    Function to fetch auth token
     */
    fun getToken(context: Context): String? {
        return getString(context, USER_TOKEN, tokenTag)
    }

    /*
    Function to fetch username
     */
    fun getUsername(context: Context): String? {
        return getString(context, USER_NAME, usernameTag)
    }

    fun saveString(context: Context, key: String, value: String, name: Int) {
//        val prefs: SharedPreferences = context.getSharedPreferences(
//            context.getString(R.string.app_name), Context.MODE_PRIVATE
//        )
        val prefs: SharedPreferences = context.getSharedPreferences(
            context.getString(name), Context.MODE_PRIVATE
        )
        val editor = prefs.edit()
        editor.putString(key, value)
        editor.apply()
    }


    fun getString(context: Context, key: String, name: Int): String? {
//        val prefs: SharedPreferences =
//            context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        val prefs: SharedPreferences =
            context.getSharedPreferences(context.getString(name), Context.MODE_PRIVATE)
//        return prefs.getString(this.USER_TOKEN, null)
        return prefs.getString(key, null)
    }

    fun clearData(context: Context) {
        // Delete Token
        val editor =
            context.getSharedPreferences(
                context.getString(R.string.token_tag),
                Context.MODE_PRIVATE
            )
                .edit()
        editor.clear()
        editor.apply()
        // Delete Username
        val editor2 =
            context.getSharedPreferences(
                context.getString(R.string.username_tag),
                Context.MODE_PRIVATE
            )
                .edit()
        editor2.clear()
        editor2.apply()
    }

}