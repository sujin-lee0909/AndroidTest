package com.example.savingnotificaion

//데이터 클래스는 프로퍼티에 대한 toString(), hashCode(), equals(), copy() 메소드를 자동으로 만들어 줍니다
data class NotificationItem(val notiPackageName : String, val notiSender : String, val notiText : String, val notiSubText : String )
