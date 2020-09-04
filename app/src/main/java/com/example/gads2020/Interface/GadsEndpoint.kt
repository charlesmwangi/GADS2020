package com.example.gads2020.Interface

import com.example.gads2020.Dao.LearningLeaders
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GadsEndpoint {
    @GET("/api/hours")
    fun gethours(): Call<List<LearningLeaders>>
    @GET("/api/skilliq")
    fun getIq( key: String): Call<LearningLeaders>
}