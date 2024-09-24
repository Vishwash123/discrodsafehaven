package com.example.discord.SampleData

import com.example.discord.Datas.VCroomRvData
import com.example.discord.R

object SampleVCdata {
    fun getList():List<VCroomRvData>{
        val list = ArrayList<VCroomRvData>()
        list.add(VCroomRvData(R.drawable.wp6363997,"Uzumaki Clan",2,false))
        list.add(VCroomRvData(R.drawable.akatsuki,"Akatsuki",10,false))
        list.add(VCroomRvData(R.drawable.uchiha,"Uchiha Clan",1,false))
        list.add(VCroomRvData(R.drawable.strawhats,"Straw Hat Pirates",12,false))
        list.add(VCroomRvData(R.drawable.demonslayercorp,"Demon Slayer Corp",8,false))
        list.add(VCroomRvData(R.drawable.scoutreg,"Scout Regiment",200,false))

        return list;

    }
}