package dev.nermingules.smsokumareceiver

import android.Manifest
import android.app.Activity
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filter = IntentFilter("android.provider.Telephony.SMS_RECEIVED")
        var receiver = SmsReceiver()
        registerReceiver(receiver, filter)

        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.RECEIVE_SMS,Manifest.permission.READ_SMS),1)
    }
}