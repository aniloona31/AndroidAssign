package com.example.assignmentold.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.assignmentold.api.ApiService
import com.example.assignmentold.api.Retrofit
import com.example.assignmentold.model.Item

class ItemRepository(private val apiService: ApiService) {

    private val _itemsLiveData = MutableLiveData<List<Item>>()
    val itemsLiveData: LiveData<List<Item>>
        get() {
            return _itemsLiveData
        }

    suspend fun getItems(){
        val response = apiService.getItems()
        if (response.body()!=null){
            println("Response -> $response,")
            println("response length -> ${response.body()!!.size}")
            _itemsLiveData.postValue(response.body())
        }
    }
}