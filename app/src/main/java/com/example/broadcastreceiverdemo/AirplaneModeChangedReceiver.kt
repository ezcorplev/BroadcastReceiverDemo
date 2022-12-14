package com.example.broadcastreceiverdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeChangedReceiver(private val activity: MainActivity) : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        val airplaneModeOffText = "Airplane Mode is OFF"
        val airplaneModeOnText = "Airplane Mode is ON"

        val isAirplaneModeEnabled = intent?.getBooleanExtra("state", false) ?: return
        if (isAirplaneModeEnabled) {
            Toast.makeText(context, airplaneModeOnText, Toast.LENGTH_LONG).show()
            activity.mainTextView.text = airplaneModeOnText
        } else {
            Toast.makeText(context, airplaneModeOffText, Toast.LENGTH_LONG).show()
            activity.mainTextView.text = airplaneModeOffText

        }
    }
}