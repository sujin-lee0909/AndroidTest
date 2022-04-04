package com.example.savingnotificaion

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

//데이터 클래스는 프로퍼티에 대한 toString(), hashCode(), equals(), copy() 메소드를 자동으로 만들어 줍니다
@Entity(tableName = "NotificationItem")
data class NotificationItem (@PrimaryKey var id: Int?,
                             @ColumnInfo(name = "packageName") val notiPackageName : String,
                             @ColumnInfo(name = "sender") val notiSender : String,
                             @ColumnInfo(name = "text") val notiText : String,
                             @ColumnInfo(name = "groupName") val notiGroupName : String ) : Serializable