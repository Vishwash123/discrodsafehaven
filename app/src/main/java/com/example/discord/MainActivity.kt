package com.example.discord

import android.animation.ObjectAnimator
import android.media.Image
import android.os.Build.VERSION_CODES.M
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.discord.SampleData.SampleData
import com.example.discord.rvAdapter.rvAdapter
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.discord.fragments.BattelField
import com.example.discord.fragments.MessageDirectory
import com.example.discord.fragments.Notification_fragment
import com.example.discord.fragments.VoiceRoom


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var img : TextView
    private lateinit var frame : ConstraintLayout
    private lateinit var nav_discord : ImageView

    private lateinit var toVoiceRoom : ImageView
    private lateinit var battelField: ImageView
    private lateinit var notification : ImageView

    private var  str = false;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rv_recyclerView);
        frame = findViewById(R.id.container)
        toVoiceRoom = findViewById(R.id.voiceRoom)
        nav_discord = findViewById(R.id.navDiscord)
        battelField = findViewById(R.id.gameFight)
        notification = findViewById(R.id.notification);
        //img = findViewById(R.id.glow)
        nav_discord.setOnClickListener{
            load(MessageDirectory())
        }

        battelField.setOnClickListener{
            load(BattelField());
        }

        notification.setOnClickListener{
            load(Notification_fragment())
        }

        toVoiceRoom.setOnClickListener{
            load(VoiceRoom())
        }

//        img.setOnClickListener{
//            var hAnim: ObjectAnimator? = null
//            if(!str) hAnim = ObjectAnimator.ofFloat(img,"scaleY",2f)
//            else hAnim = ObjectAnimator.ofFloat(img,"scaleY",1f)
//            hAnim.duration = 550
//            hAnim.start()
//            str = !str
//        }

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val adapter = rvAdapter(this,SampleData.getList())
        recyclerView.adapter = adapter
    }

    fun  load( fragment: Fragment){
        val fragmentManager = getSupportFragmentManager();

        val transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(
            R.anim.slideright,
            R.anim.slideleft,
            R.anim.slideright,
            R.anim.slideleft
        )
        transaction.replace(R.id.container,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}