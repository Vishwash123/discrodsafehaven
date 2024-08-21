package com.example.discord

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.discord.SampleData.list
import com.example.discord.rvAdapter.rvAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rv_recyclerView);

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val adapter = rvAdapter(this,getList())
        recyclerView.adapter = adapter
    }

    fun getList() : List<Int>{
        val list  = ArrayList<Int>()
        list.add(R.drawable.i1)
        list.add(R.drawable.i1)
        list.add(R.drawable.i1)
        list.add(R.drawable.i1)
        list.add(R.drawable.i1)
        list.add(R.drawable.i1)
        list.add(R.drawable.i1)
        list.add(R.drawable.i1)
        list.add(R.drawable.i1)
        list.add(R.drawable.i1)
        list.add(R.drawable.i1)
        list.add(R.drawable.i1)
        list.add(R.drawable.i1)
        list.add(R.drawable.i1)
        list.add(R.drawable.i1)
        list.add(R.drawable.i1)
        list.add(R.drawable.i1)
        list.add(R.drawable.i1)
        list.add(R.drawable.i1)
        list.add(R.drawable.i1)
        list.add(R.drawable.i1)
        list.add(R.drawable.i1)
        list.add(R.drawable.i1)
        list.add(R.drawable.i1)

        return list
    }
}