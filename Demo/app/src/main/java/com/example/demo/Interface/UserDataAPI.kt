package com.example.demo.Interface

import com.example.demo.Model.UserDataResponse
import com.example.demo.Model.UserPost
import retrofit2.Call
import retrofit2.http.GET

interface UserDataAPI {

    @GET("octocat")
    fun getUserData() : Call<UserDataResponse>


    @GET("posts")
    fun getUserPost() : Call<UserPost>


}