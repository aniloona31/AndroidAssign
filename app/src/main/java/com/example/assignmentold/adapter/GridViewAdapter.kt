package com.example.assignmentold.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignmentold.R
import com.example.assignmentold.model.Item
import java.util.zip.Inflater

class GridViewAdapter() : RecyclerView.Adapter<GridViewAdapter.ViewHolder>() {

    private var itemList = mutableListOf<Item>()

    fun setItems(items: List<Item>){
        itemList = items.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GridViewAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_grid_view_item,parent,false))
    }

    override fun onBindViewHolder(holder: GridViewAdapter.ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Item) {
            val itemImage = itemView.findViewById<ImageView>(R.id.gridItemImage)
            val itemPrice = itemView.findViewById<TextView>(R.id.gridItemPrice)
            Glide.with(itemView.context).load(item.image).into(itemImage)
            itemPrice.text = item.price.toString();
        }

    }
}