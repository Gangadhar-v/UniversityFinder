package com.example.universityfinder

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.universityfinder.model.Universities
import com.example.universityfinder.model.University
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class UniversityViewModel(application: Application): AndroidViewModel(application) {

    val repo = UniversityRepository()
    private val _universities = MutableLiveData<List<University>>()
    val universities : LiveData<List<University>>
        get() = _universities
    private val _error = MutableLiveData<String>()
    val error:LiveData<String>
        get() = _error

    fun fetchUniversities(country: String) {
        viewModelScope.launch {
            try {
                val response: Response<List<University>> = repo.getUniversities(country)
                if (response.isSuccessful) {
                    _universities.postValue(response.body())
                }
            } catch (e: Exception) {
                e.printStackTrace()

            }
        }
    }
}