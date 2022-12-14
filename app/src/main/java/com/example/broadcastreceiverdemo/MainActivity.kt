package com.example.broadcastreceiverdemo

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    public lateinit var mainTextView: TextView
    lateinit var receiver: AirplaneModeChangedReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        receiver = AirplaneModeChangedReceiver(this)
        mainTextView = findViewById(R.id.tv_main)

//        val airplaneModeOn = Settings.Global.getInt(this.contentResolver, Settings.Global.AIRPLANE_MODE_ON, 0) != 0


        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also { // on this specific intent ->
            registerReceiver(receiver, it) // register our receiver instance
        }

//        mainTextView.text = if (airplaneModeOn) "Airplane mode is ON" else "Airplane mode is OFF"

//        if (airplaneModeOn) {
//            mainTextView.text = airplaneModeOnText
//        } else mainTextView.text = airplaneModeOffText

//        if (Settings.System.getInt(contentResolver, Settings.Global.AIRPLANE_MODE_ON, 0) == 0) {
//            mainTextView.text = airplaneModeOffText
//        } else if (Settings.System.getInt(contentResolver, Settings.Global.AIRPLANE_MODE_ON, 0) != 0){
//            mainTextView.text = airplaneModeOnText
//        }
    }

        override fun onStop() {
            super.onStop()
            unregisterReceiver(receiver)
        }
    }