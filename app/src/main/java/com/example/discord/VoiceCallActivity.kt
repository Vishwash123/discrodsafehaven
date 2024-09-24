package com.example.discord

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.discord.SampleData.SampleVCdata
import com.example.discord.rvAdapter.VcCallRvAdapter

class VoiceCallActivity : AppCompatActivity() {
    private lateinit var vcCall_recyclerView: RecyclerView
    private lateinit var vcCall_rvAdapter: VcCallRvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_voice_call)
        vcCall_recyclerView = findViewById(R.id.voiceCall_member_rv)
        vcCall_recyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)
        vcCall_rvAdapter = VcCallRvAdapter(this, SampleVCdata.getList())

        vcCall_recyclerView.adapter = vcCall_rvAdapter


    }
}