package com.example.demo.utilClass

import com.example.demo.listener.UserDataAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * File to create retrofit object
 * Date:15-01-2025
 */
object RetrofitInstance {

    val api : UserDataAPI by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.github.com/users/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserDataAPI::class.java)
    }
}