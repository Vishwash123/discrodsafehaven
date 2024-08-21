package com.example.discord.rvAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.discord.R

class rvAdapter(val context: Context,val list: List<Int>) : RecyclerView.Adapter<rvAdapter.ViewHolder>(){
     inner class ViewHolder(val item:View) : RecyclerView.ViewHolder(item) {
         val icon = item.findViewById<ImageView>(R.id.side_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rvAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.icon_rv,parent,false))
    }

    override fun onBindViewHolder(holder: rvAdapter.ViewHolder, position: Int) {
        holder.icon.setImageResource(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}