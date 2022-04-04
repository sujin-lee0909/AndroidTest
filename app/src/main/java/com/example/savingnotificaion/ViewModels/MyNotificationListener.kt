package com.example.savingnotificaion.ViewModels

import android.app.Notification
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.text.TextUtils
import android.util.Log
import java.io.Serializable

//이거 왜 object로하면 에러남??
class MyNotificationListener : NotificationListenerService(){
    private val nlServiceReceiver : NLServiceReceiver = NLServiceReceiver()
    private var num : Int = 0
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
        val extraSender :String = extras?.get(Notification.EXTRA_TITLE).toString()
        val extraText: String = extras?.get(Notification.EXTRA_TEXT).toString()
        val extraGroupName: String = extras?.get(Notification.EXTRA_SUB_TEXT).toString()

        if (packageName != "com.kakao.talk" || TextUtils.isEmpty(packageName)) return

        val noti = com.example.savingnotificaion.NotificationItem(
            num++,
            packageName,
            extraSender,
            extraText,
            extraGroupName
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

