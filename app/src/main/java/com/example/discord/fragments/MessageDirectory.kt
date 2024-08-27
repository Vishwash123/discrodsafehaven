package com.example.discord.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.discord.R
import com.example.discord.SampleData.SampleData_user
import com.example.discord.rvAdapter.userAdapter


class MessageDirectory : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: userAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View =  inflater.inflate(R.layout.fragment_message_directory, container, false)

        recyclerView = view.findViewById(R.id.userRecyclerView);

        recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        userAdapter  = userAdapter(requireContext(),SampleData_user.getList())

        recyclerView.adapter = userAdapter

        return view;
    }

}