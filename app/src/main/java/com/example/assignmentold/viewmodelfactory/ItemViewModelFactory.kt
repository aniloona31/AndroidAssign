package com.example.assignmentold.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assignmentold.repository.ItemRepository
import com.example.assignmentold.viewmodel.ItemViewModel

class ItemViewModelFactory(private val itemRepository: ItemRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemViewModel(itemRepository) as T

    }
}