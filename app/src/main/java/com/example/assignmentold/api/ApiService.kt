package com.example.assignmentold.api

import com.example.assignmentold.model.Item
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("v3/ebd8cc2f-b878-4062-847b-0b15530ab071")
    suspend fun getItems(): Response<List<Item>>
}

