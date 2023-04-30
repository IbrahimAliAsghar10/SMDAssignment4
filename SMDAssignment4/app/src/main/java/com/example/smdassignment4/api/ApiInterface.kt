package com.example.smdassignment4.api

import com.example.smdassignment4.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

public interface ApiInterface {
    @GET("/getCategoriesAndPopulars") fun getCategoriesAndPopularsList(): Call<ApiResponse>
}