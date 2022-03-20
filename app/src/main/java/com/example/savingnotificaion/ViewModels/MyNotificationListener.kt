package com.example.savingnotificaion.ViewModels

import android.app.Notification
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class MyNotificationListener : NotificationListenerService() {
    private val TAG = "MyNotificationListener"
    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        super.onNotificationPosted(sbn)

        val packageName : String = sbn?.packageName ?:"Null"
        val extras = sbn?.notification?.extras
        val extraTitle: String = extras?.get(Notification.EXTRA_TITLE).toString()
        val extraText: String = extras?.get(Notification.EXTRA_TEXT).toString()
        val extraMessagingPerson :String = extras?.get(Notification.EXTRA_MESSAGING_PERSON).toString()
        val extraBigText: String = extras?.get(Notification.EXTRA_BIG_TEXT).toString()
        val extraInfoText: String = extras?.get(Notification.EXTRA_INFO_TEXT).toString()

        val noti = com.example.savingnotificaion.NotificationItem(
            packageName,
            extraMessagingPerson,
            extraText,
            extraInfoText
        )
        Log.d(TAG, noti.toString())
    }

}