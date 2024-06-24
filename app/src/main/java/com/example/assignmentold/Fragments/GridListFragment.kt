package com.example.assignmentold.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentold.R
import com.example.assignmentold.adapter.GridViewAdapter
import com.example.assignmentold.adapter.ListViewAdapter
import com.example.assignmentold.api.ApiService
import com.example.assignmentold.api.Retrofit
import com.example.assignmentold.databinding.FragmentGridListBinding
import com.example.assignmentold.databinding.FragmentLinearListBinding
import com.example.assignmentold.model.Item
import com.example.assignmentold.repository.ItemRepository
import com.example.assignmentold.viewmodel.ItemViewModel
import com.example.assignmentold.viewmodelfactory.ItemViewModelFactory

//import retrofit.Callback
//import retrofit.Response


class GridListFragment : Fragment() {

    private var _binding: FragmentGridListBinding? = null
    private val binding get() = _binding!!
    private lateinit var itemViewModel: ItemViewModel
    private lateinit var adapter: GridViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val retrofitHelper = Retrofit.getInstance().create(ApiService::class.java)
        val repository = ItemRepository(retrofitHelper)
        itemViewModel = ViewModelProvider(this, ItemViewModelFactory(repository)).get(ItemViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGridListBinding.inflate(inflater,container,false)
        adapter = GridViewAdapter()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindObservers()
        itemViewModel.getItems()
        binding.recyclerGridView.layoutManager = GridLayoutManager(context,3)
        binding.recyclerGridView.adapter = adapter

    }

    private fun bindObservers() {
        itemViewModel.itemsLiveData.observe(viewLifecycleOwner, Observer {
            if(it!=null)
                adapter.setItems(it)
        })
    }


    companion object {

    }
}