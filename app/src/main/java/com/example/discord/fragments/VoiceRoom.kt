package com.example.discord.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.discord.Datas.VCroomRvData
import com.example.discord.R
import com.example.discord.SampleData.SampleVCdata
import com.example.discord.VoiceCallActivity
import com.example.discord.rvAdapter.VCRoom_rvAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [VoiceRoom.newInstance] factory method to
 * create an instance of this fragment.
 */
class VoiceRoom : Fragment() {
    private lateinit var vcRecyclerView: RecyclerView
    private lateinit var vcRvAdapter:VCRoom_rvAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_voice_room, container, false)

        vcRecyclerView = view.findViewById(R.id.VC_room_RV)
        vcRecyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        vcRvAdapter = VCRoom_rvAdapter(requireContext(),SampleVCdata.getList()){
            val intent = Intent(requireContext(), VoiceCallActivity::class.java)
            startActivity(intent)
        }

        vcRecyclerView.adapter = vcRvAdapter

        return view;
    }








}