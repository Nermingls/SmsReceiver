package dev.nermingules.smsokumareceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.util.Log

class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        if(intent.extras != null){
            (intent.extras!!["pdus"] as Array<Any>?).let{
                var mesajMetni =""
                var sms : SmsMessage? = null

                for(pdu:Any in it!!){
                    sms = SmsMessage.createFromPdu(pdu as ByteArray)
                    mesajMetni += sms.messageBody
                }
                var sender = sms!!.originatingAddress

                Log.d("***","${sender} tarafından gönderilen mesaj \n ${mesajMetni}")
            }
        }
    }
}