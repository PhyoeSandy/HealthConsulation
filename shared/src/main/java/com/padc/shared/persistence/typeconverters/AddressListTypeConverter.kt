package com.padc.shared.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padc.shared.data.vos.AddressVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/2/2020.
 */
class AddressListTypeConverter {

    @TypeConverter
    fun toString(list: ArrayList<AddressVO>) : String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toGenreList(listJsonString: String) : ArrayList<AddressVO> {
        val listType = object : TypeToken<ArrayList<AddressVO>>() {}.type
        return Gson().fromJson(listJsonString,listType)
    }

}