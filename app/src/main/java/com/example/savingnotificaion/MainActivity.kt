package com.example.savingnotificaion

import android.app.NotificationManager
import android.content.*
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import com.example.savingnotificaion.ViewModels.MyNotificationListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val TAG = "MyNotificationListener"
    private val broadcastReceiver = NotificationReceiver()
    private var items = mutableListOf<NotificationItem>()
    private val adapter = ListViewAdapter(items)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(!isNotificationPermissionGranted()) {
            startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS))
        }

        val filter = IntentFilter()
        filter.addAction(".ViewModels.MyNotificationListener")
        registerReceiver(broadcastReceiver, filter)

        items.add(NotificationItem("com.kakao.talk","수진","테스트지롱","갠"))

        val adapter = ListViewAdapter(items)
        friend_list_view.adapter = adapter
    }

    private fun isNotificationPermissionGranted(): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            return notificationManager.isNotificationListenerAccessGranted(
                ComponentName(
                    application,
                    MyNotificationListener::class.java
                )
            )
        } else {
            return NotificationManagerCompat.getEnabledListenerPackages(applicationContext).contains(applicationContext.packageName)
        }
    }

    inner class NotificationReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            Log.d("?",intent.getStringExtra("notification_event"))
            //TODO : 객체 전달하게
            items.add(NotificationItem("com.kakao.talk", "2","2","2"))
            adapter.notifyDataSetChanged()
        }
    }
}