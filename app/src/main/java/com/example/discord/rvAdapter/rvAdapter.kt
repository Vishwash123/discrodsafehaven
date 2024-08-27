package com.example.discord.rvAdapter

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.discord.R

class rvAdapter(val context: Context,val list: List<Int>) : RecyclerView.Adapter<rvAdapter.ViewHolder>(){

    private var str = false
    private var privous_state = -1
    private var StateFlow : TextView ?= null
     inner class ViewHolder(val item:View) : RecyclerView.ViewHolder(item) {
         val icon = item.findViewById<ImageView>(R.id.side_icon)
         val flow = item.findViewById<TextView>(R.id.glow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rvAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.icon_rv,parent,false))
    }

    override fun onBindViewHolder(holder: rvAdapter.ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.icon.setImageResource(list[position])

        holder.icon.setOnClickListener{

            var hanim : ObjectAnimator ?= null
            if(privous_state>=0 && StateFlow != null){
                hanim = ObjectAnimator.ofFloat(StateFlow,"scaleY",1.0f)
                hanim.duration = 300
                hanim.start()
                str = !str
            }

            if(!str){
                hanim = ObjectAnimator.ofFloat(holder.flow,"scaleY",3.0f)
            }else{
                hanim = ObjectAnimator.ofFloat(holder.flow,"scaleY",1.0f)
            }
            str = !str

            hanim.duration = 300
            hanim.start()

            privous_state = position
            StateFlow  = holder.flow
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}