package com.example.gads2020.Interface

import com.example.gads2020.Dao.LearningLeaders
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface GadsEndpoint {
    @GET("/api/hours")
    fun gethours(): Call<List<LearningLeaders>>

    @GET("/api/skilliq")
    fun getIq(): Call<List<LearningLeaders>>

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    fun submitProject(
        @Field("entry.1877115667") firstName: String,
        @Field("entry.2006916086") secondName: String,
        @Field("entry.1824927963") email: String,
        @Field("entry.284483984") projectLink: String

    ): Call<ResponseBody>
}