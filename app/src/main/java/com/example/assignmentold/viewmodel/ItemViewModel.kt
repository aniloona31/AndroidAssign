package com.example.assignmentold.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignmentold.model.Item
import com.example.assignmentold.repository.ItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ItemViewModel constructor(private val itemRepository: ItemRepository): ViewModel() {

    val itemsLiveData: LiveData<List<Item>>
    get() = itemRepository.itemsLiveData

    fun getItems(){
        viewModelScope.launch(Dispatchers.IO) {
            itemRepository.getItems()
        }
    }
}