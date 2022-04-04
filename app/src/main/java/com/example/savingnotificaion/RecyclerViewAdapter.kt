package com.example.savingnotificaion

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val context: Context) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    var datas = mutableListOf<NotificationItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.friend_list,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val groupName: TextView = itemView.findViewById(R.id.group_name)
        private val friendName: TextView = itemView.findViewById(R.id.friend_name)
        private val friendText: TextView = itemView.findViewById(R.id.friend_text)
//        private val imgProfile: ImageView = itemView.findViewById(R.id.friend_image)

        fun bind(item: NotificationItem) {
            groupName.text = item.notiGroupName
            friendName.text = item.notiSender
            friendText.text = item.notiText
        }

    }
}