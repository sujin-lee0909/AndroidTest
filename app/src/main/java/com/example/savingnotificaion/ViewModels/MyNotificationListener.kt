package com.example.savingnotificaion.ViewModels

import android.app.Notification
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log
import java.io.Serializable

//이거 왜 object로하면 에러남??
class MyNotificationListener : NotificationListenerService(){
    private val nlServiceReceiver : NLServiceReceiver = NLServiceReceiver()

    override fun onCreate() {
        super.onCreate()
        val filter = IntentFilter()
        filter.addAction(".ViewModels.MyNotificationListener")
        registerReceiver(nlServiceReceiver, filter)
    }

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        super.onNotificationPosted(sbn)

        val packageName : String = sbn?.packageName ?:"Null"
        val extras = sbn?.notification?.extras
        val extraText: String = extras?.get(Notification.EXTRA_TEXT).toString()
        val extraMessagingPerson :String = extras?.get(Notification.EXTRA_MESSAGING_PERSON).toString()
        val extraInfoText: String = extras?.get(Notification.EXTRA_INFO_TEXT).toString()

        val noti = com.example.savingnotificaion.NotificationItem(
            packageName,
            extraMessagingPerson,
            extraText,
            extraInfoText
        )

        val intent : Intent = Intent(".ViewModels.MyNotificationListener")
        intent.putExtra("notification_event", noti)
        sendBroadcast(intent)
    }

    class NLServiceReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {
        }
    }
}

