package com.example.savingnotificaion.Models

import androidx.room.Dao
import androidx.room.Query
import com.example.savingnotificaion.NotificationItem

@Dao
interface NotificationDao {
    @Query("SELECT * FROM NotificationItem")
    fun getAll(): List<NotificationItem>

    @Query("DELETE from NotificationItem")
    fun deleteAll()
}