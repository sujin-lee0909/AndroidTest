package com.example.savingnotificaion.ViewModels

import android.app.Notification
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.savingnotificaion.NotificationItem
import com.example.savingnotificaion.R
import kotlinx.android.synthetic.main.friend_list.view.*

class ListViewAdapter (private val items : MutableList<NotificationItem>): BaseAdapter() {

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        var convertView = view
        if (convertView == null) convertView = LayoutInflater.from(parent?.context).inflate(R.layout.friend_list, parent, false)

        val item : NotificationItem = items[position]
        convertView!!.friend_name.text = item.notiSender
        convertView.friend_text.text = item.notiText

        return convertView
    }

    override fun getItem(position: Int): NotificationItem = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = items.size
}