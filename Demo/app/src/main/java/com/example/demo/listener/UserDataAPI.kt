package com.example.demo.listener

import com.example.demo.model.UserDataResponse
import com.example.demo.model.UserPost
import retrofit2.Call
import retrofit2.http.GET

interface UserDataAPI {

    @GET("octocat")
    fun getUserData() : Call<UserDataResponse>


    @GET("posts")
    fun getUserPost() : Call<UserPost>


}