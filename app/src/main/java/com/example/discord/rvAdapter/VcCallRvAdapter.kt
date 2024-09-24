package com.example.discord.rvAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.discord.Datas.VCroomRvData
import com.example.discord.Datas.userRvData
import com.example.discord.R
import de.hdodenhof.circleimageview.CircleImageView

class VcCallRvAdapter(val context: Context, private val list:List<VCroomRvData>):RecyclerView.Adapter<VcCallRvAdapter.VcCallViewHolder>() {
    inner class VcCallViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val photo:CircleImageView = itemView.findViewById(R.id.vc_call_rv_item_photo)
        val name:TextView = itemView.findViewById(R.id.vc_call_rv_item_name)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VcCallViewHolder {
        return VcCallViewHolder(LayoutInflater.from(context).inflate(R.layout.vc_call_rv_item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VcCallViewHolder, position: Int) {
        val currentUser = list[position]
        holder.photo.setImageResource(currentUser.vcPhoto)
        holder.name.text = currentUser.vcName


    }
}