package com.padc.shared.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padc.shared.data.vos.DoctorVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/2/2020.
 */
class RecentlyDocListTypeConverter {

    @TypeConverter
    fun toString(list: ArrayList<DoctorVO>) : String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toGenreList(listJsonString: String) : ArrayList<DoctorVO> {
        val listType = object : TypeToken<ArrayList<DoctorVO>>() {}.type
        return Gson().fromJson(listJsonString,listType)
    }

}