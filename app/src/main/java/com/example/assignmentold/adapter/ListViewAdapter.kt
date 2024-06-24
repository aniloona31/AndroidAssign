package com.example.assignmentold.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignmentold.R
import com.example.assignmentold.model.Item

class ListViewAdapter() :
    RecyclerView.Adapter<ListViewAdapter.ViewHolder>() {

    private var itemList = mutableListOf<Item>()

    public fun setItems(items: List<Item>){
        this.itemList = items.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_recycler_view_item,parent,false))
    }

    override fun onBindViewHolder(holder: ListViewAdapter.ViewHolder, position: Int) {
        if(itemList[position] != null){
            holder.bind(itemList[position])
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


    public class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Item) {
//            println(item)
            val itemImage = itemView.findViewById<ImageView>(R.id.itemImage)
            val itemPrice = itemView.findViewById<TextView>(R.id.itemPrice)
            Glide.with(itemView.context).load(item.image).into(itemImage)
            itemPrice.text = item.price.toString()
        }

    }


}