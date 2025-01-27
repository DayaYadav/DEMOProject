package com.example.demo.ViewModelClass

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo.model.UserDataResponse
import com.example.demo.utilClass.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * ViewModel file to fetch user details from the dummy API
 * Date: 14-01-2025
 */
class HomeViewModel : ViewModel() {

    var userLiveData = MutableLiveData<UserDataResponse>()

    private val _isLoading = MutableLiveData<Boolean>(false)

    val isLoading: LiveData<Boolean> = _isLoading

    /**
     * Function to launch coroutine to fetch userdata
     */
    fun getUserData() {
        _isLoading.postValue(true)
        viewModelScope.launch {
            getUserDataDetails()
        }
    }

    /**
     * Function to call API to fetch user data from the server
     */
    private fun getUserDataDetails() {
        RetrofitInstance.api.getUserData().enqueue(object : Callback<UserDataResponse> {
            override fun onResponse(
                call: Call<UserDataResponse>,
                response: Response<UserDataResponse>
            ) {
                if (response.body() != null) {
                    userLiveData.value = response.body()
                    _isLoading.postValue(false)
                } else {
                    return
                }
            }

            override fun onFailure(call: Call<UserDataResponse>, t: Throwable) {
                Log.d("TAG", t.message.toString())
            }

        }
        )
    }
}

