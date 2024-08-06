package com.example.utilitytracker.data.repository

import com.example.utilitytracker.data.api.ApiClient
import com.example.utilitytracker.data.model.Consumption
import com.example.utilitytracker.data.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiRepository {

    private val apiService = ApiClient.apiService

    fun login(user: User, onResult: (Response<User>?) -> Unit, onError: (Throwable) -> Unit) {
        apiService.login(user).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                onResult(response)
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                onError(t)
            }
        })
    }

    fun getConsumptions(onResult: (Response<List<Consumption>>) -> Unit, onError: (Throwable) -> Unit) {
        apiService.getConsumptions().enqueue(object : Callback<List<Consumption>> {
            override fun onResponse(call: Call<List<Consumption>>, response: Response<List<Consumption>>) {
                onResult(response)
            }

            override fun onFailure(call: Call<List<Consumption>>, t: Throwable) {
                onError(t)
            }
        })
    }

    fun addConsumption(consumption: Consumption, onResult: (Response<Consumption>) -> Unit, onError: (Throwable) -> Unit) {
        apiService.addConsumption(consumption).enqueue(object : Callback<Consumption> {
            override fun onResponse(call: Call<Consumption>, response: Response<Consumption>) {
                onResult(response)
            }

            override fun onFailure(call: Call<Consumption>, t: Throwable) {
                onError(t)
            }
        })
    }
}
