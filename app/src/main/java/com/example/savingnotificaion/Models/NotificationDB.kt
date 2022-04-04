package com.example.savingnotificaion.Models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.savingnotificaion.NotificationItem

@Database(entities = [NotificationItem::class], version = 1)
abstract class NotificationDB : RoomDatabase() {
    abstract fun notificationDao(): NotificationDao

    companion object {
        private var INSTANCE: NotificationDB? = null

        fun getInstance(context: Context): NotificationDB? {
            if (INSTANCE == null) {
                synchronized(NotificationDB::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        NotificationDB::class.java, "notification.db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}