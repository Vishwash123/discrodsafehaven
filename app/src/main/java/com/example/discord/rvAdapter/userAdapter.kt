package com.example.discord.rvAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.discord.Datas.userRvData
import com.example.discord.R
import de.hdodenhof.circleimageview.CircleImageView

class userAdapter(val context: Context, val userList: List<userRvData>): RecyclerView.Adapter<userAdapter.UserViewHolder>(){

    private var privous_state: ConstraintLayout ? = null
    private var privous_state_res: ImageView ? = null
    private var privous_main :ConstraintLayout ? = null

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val icon : CircleImageView = itemView.findViewById(R.id.profile_image);
        val username : TextView = itemView.findViewById(R.id.name)
        val container : ConstraintLayout =itemView.findViewById(R.id.option_container)
        val restrict_icon : ImageView = itemView.findViewById(R .id.restrict)
        val main : ConstraintLayout = itemView.findViewById(R.id.main_container)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_user_item,parent,false))
    }

    override fun getItemCount(): Int {
        return userList.size;
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = userList[position];
        holder.username.text = currentUser.name;
        holder.icon.setImageResource(currentUser.user)
        holder.container.visibility = View.GONE
        holder.restrict_icon.visibility = View.GONE

        holder.main.setOnClickListener{

            if(holder.container.visibility == View.GONE){

                if(privous_state != null){
                    privous_state?.visibility = View.GONE
                    privous_state_res?.visibility = View.GONE
                    privous_main?.background = null
                }

                holder.container.visibility = View.VISIBLE
                holder.restrict_icon.visibility = View.VISIBLE
                holder.main.setBackgroundResource(R.drawable.button_background_dark)

                privous_state = holder.container
                privous_main = holder.main
                privous_state_res = holder.restrict_icon
            }else{
                holder.container.visibility = View.GONE
                holder.restrict_icon.visibility = View.GONE
                holder.main.background = null
            }
        }

    }
}