package com.example.assignmentold.api


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {

    fun getInstance(): Retrofit {
        val gson: Gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder().baseUrl("https://run.mocky.io/")
            .addConverterFactory(GsonConverterFactory.create(gson)).build()
    }

}