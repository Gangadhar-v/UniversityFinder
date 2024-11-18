package com.example.universityfinder

import android.telecom.Call
import com.example.universityfinder.model.Universities
import com.example.universityfinder.model.University
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("search")
    suspend fun getUniversities(
        @Query("country") country:String
    ): retrofit2.Response<List<University>>
}