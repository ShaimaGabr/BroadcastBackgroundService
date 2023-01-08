package com.example.forgroundservicewithnotification

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class SoundService : Service() {
    lateinit var mp:MediaPlayer

    override fun onCreate() {
        super.onCreate()
        mp= MediaPlayer.create(this,R.raw.music)
        mp.setOnCompletionListener {
            stopSelf()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if(mp!=null && mp.isPlaying){
            mp.stop()
            mp.release()
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if(!mp.isPlaying){
            mp.start()
        }
        return super.onStartCommand(intent, flags, startId)
    }
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}