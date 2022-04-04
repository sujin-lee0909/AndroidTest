package com.example.savingnotificaion

import android.app.NotificationManager
import android.content.*
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import com.example.savingnotificaion.Models.NotificationDB
import com.example.savingnotificaion.ViewModels.MyNotificationListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val TAG = "MyNotificationListener"
    private val notificationReceiver = NotificationReceiver()
    private var datas = mutableListOf<NotificationItem>()
    private var notificationDB : NotificationDB? = null
    private val recyclerViewAdapter = RecyclerViewAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(!IsNotificationPermissionGranted()) {
            startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS))
        }

        notificationDB = NotificationDB.getInstance(this)

        val filter = IntentFilter()
        filter.addAction(".ViewModels.MyNotificationListener")
        registerReceiver(notificationReceiver, filter)

        friend_recycler_view.adapter = recyclerViewAdapter
        recyclerViewAdapter.datas = datas
    }

    private fun IsNotificationPermissionGranted(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.isNotificationListenerAccessGranted(
                ComponentName(
                    application,
                    MyNotificationListener::class.java
                )
            )
        } else {
            NotificationManagerCompat.getEnabledListenerPackages(applicationContext).contains(applicationContext.packageName)
        }
    }

    inner class NotificationReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val newNotification = intent.getSerializableExtra("notification_event") as NotificationItem
            Log.d(TAG, newNotification.toString())
            datas.add(newNotification)
            recyclerViewAdapter.notifyDataSetChanged()

        }
    }
}