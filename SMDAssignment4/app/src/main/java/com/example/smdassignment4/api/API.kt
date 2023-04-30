package com.example.smdassignment4.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


public class API {
    private val localHost = "http://127.0.0.1:5000"
    public fun getClient(): ApiInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl(localHost).addConverterFactory(GsonConverterFactory.create())
            .build();
        return retrofit.create(ApiInterface::class.java)
    }
}