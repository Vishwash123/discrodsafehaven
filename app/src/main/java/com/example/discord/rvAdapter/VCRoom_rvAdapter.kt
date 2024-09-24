package com.example.discord.rvAdapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.service.autofill.UserData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.discord.Datas.VCroomRvData
import com.example.discord.Datas.userRvData
import com.example.discord.R
import com.example.discord.SampleData.SampleData_user
import com.example.discord.SampleData.SampleVCdata
import de.hdodenhof.circleimageview.CircleImageView

class VCRoom_rvAdapter(val context: Context,val vclist:List<VCroomRvData>
,private val itemClickListener: (VCroomRvData) -> Unit):RecyclerView.Adapter<VCRoom_rvAdapter.VCRoomViewHolder>(){

    inner class VCRoomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var vcIcon:CircleImageView = itemView.findViewById(R.id.VC_room_rv_item_vc_image)
        var vcName:TextView = itemView.findViewById(R.id.VC_room_rv_item_vc_name)
        var vcMembers:TextView = itemView.findViewById(R.id.VC_room_rv_item_vc_member_count)

        val memberPhotosContainer:LinearLayout = itemView.findViewById(R.id.VC_Room_rv_item_users_layout)

        @SuppressLint("SetTextI18n")
        fun bind() {
            // Clear any existing views
            memberPhotosContainer.removeAllViews()

            // Add member photos to the container
            val members = SampleVCdata.getList();
            for (i in 0 until minOf(members.size, 4)) {
                val member = members[i]
                val imageView = CircleImageView(itemView.context).apply {
                    layoutParams = LinearLayout.LayoutParams(44, 44).apply {
                        marginEnd = -18

                    }
                    setImageResource(member.vcPhoto) // Assuming Member has a photoResId property
                }
                memberPhotosContainer.addView(imageView)
            }

            // Show ellipsis if there are more than 4 members
            if (members.size > 4) {

                val ellipsis = TextView(itemView.context).apply {
                    text = "   +" + (members.size-4).toString() + " more"
                    textSize = 12F
                    setTextColor(Color.WHITE)
                }
                memberPhotosContainer.addView(ellipsis)
            }
        }


        fun bind2(item:VCroomRvData,itemClickListener:(VCroomRvData)->Unit){
            itemView.setOnClickListener{
                itemClickListener(item)
            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VCRoomViewHolder {
        return VCRoomViewHolder(LayoutInflater.from(context).inflate(R.layout.vc_room_rv_item,parent,false))

    }

    override fun getItemCount(): Int {
        return vclist.size
    }

    override fun onBindViewHolder(holder: VCRoomViewHolder, position: Int) {
        val currentVC = vclist[position]
        holder.vcIcon.setImageResource(currentVC.vcPhoto)
        holder.vcName.text = currentVC.vcName
        var extra:String
        if(currentVC.vcMembers==1){
            extra = " member"
        }
        else{
            extra = " members"
        }
        holder.vcMembers.text = currentVC.vcMembers.toString() + extra + " talking"
        holder.bind()
        holder.bind2(currentVC,itemClickListener)



    }
}