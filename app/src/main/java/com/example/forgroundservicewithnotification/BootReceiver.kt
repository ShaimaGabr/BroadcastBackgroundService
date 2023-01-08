package com.example.forgroundservicewithnotification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
//import com.example.handfreebroadcastsound.SoundService

class BootReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent!!.action.equals("android.intent.action.HEADSET_PLUG")){
        val state:Int = intent!!.getIntExtra("state",-1)
       if(state==0) {
           context!!.stopService(Intent(context, SoundService::class.java))
           Toast.makeText(context, "Un plugged", Toast.LENGTH_SHORT).show()
       }
       else if(state==1) {
           context!!.startService(Intent(context, SoundService::class.java))
           Toast.makeText(context, "plugged in", Toast.LENGTH_SHORT).show()
       }


    }}
}