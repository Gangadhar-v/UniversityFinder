package com.example.universityfinder

import com.example.universityfinder.model.University
import retrofit2.Call
import retrofit2.Response

class UniversityRepository {

    private val apiService = RetrofitInstance.api

    suspend fun getUniversities(country: String): Response<List<University>> {
        return apiService.getUniversities(country)
    }
}