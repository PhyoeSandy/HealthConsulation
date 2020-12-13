package com.padc.shared.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padc.shared.data.vos.ChatVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/2/2020.
 */
class ChatListTypeConverter {

    @TypeConverter
    fun toString(list: ArrayList<ChatVO>) : String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toChatList(listJsonString: String) : ArrayList<ChatVO> {
        val listType = object : TypeToken<ArrayList<ChatVO>>() {}.type
        return Gson().fromJson(listJsonString,listType)
    }

}