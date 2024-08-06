package com.example.utilitytracker.api

import com.example.utilitytracker.data.model.User
import com.example.utilitytracker.data.model.Consumption
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    fun login(@Body user: User): Call<User>

    @GET("consumptions")
    fun getConsumptions(): Call<List<Consumption>>

    @POST("consumptions")
    fun addConsumption(@Body consumption: Consumption): Call<Consumption>
}
