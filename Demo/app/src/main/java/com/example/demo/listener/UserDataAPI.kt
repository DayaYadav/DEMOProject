package com.example.demo.listener

import com.example.demo.model.UserDataResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Interface to declare method to fetch data from the server
 */
interface UserDataAPI {

    @GET("octocat")
    fun getUserData() : Call<UserDataResponse>
}