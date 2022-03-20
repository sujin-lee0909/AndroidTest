package com.example.savingnotificaion

/*
    PackageName: com.kakao.talkTitle: 조성현
    Text: 그니까 군대다..ㅋㅋㅋㅋㅋ
    BigText: null
    InfoText: null
    SubText: null //단톡방 이름
    SummaryText: null
 */

data class NotificationItem(val notiPackageName : String, val notiSender : String, val notiText : String, val notiSubText : String )

//class Notification {
//    private val notiPackageName : String
//    private val notiSender : String
//    private val notiText : String
//    private val notiSubText : String
////    private var notiBigText : String = "null"
////    private var notiInfoText : String = "null"
////    private var notiSummaryText : String = "null"
//
//    constructor(packageName : String, sender : String, text : String, subText : String){
//        this.notiPackageName = packageName
//        this.notiSender = sender
//        this.notiText = text
//        this.notiSubText = subText
//    }
//
//
//    override fun toString(): String {
//        return "packageName : $notiPackageName sender : $notiSender text : $notiText subText : $notiSubText"
//    }
//}