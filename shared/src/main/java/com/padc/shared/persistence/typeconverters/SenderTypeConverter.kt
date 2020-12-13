package com.padc.shared.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padc.shared.data.vos.SenderVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/2/2020.
 */
class SenderTypeConverter {

    @TypeConverter
    fun toString(data: SenderVO) : String {
        return Gson().toJson(data)
    }

    @TypeConverter
    fun todata(dataJsonString: String) : SenderVO {
        val dataType = object : TypeToken<SenderVO>() {}.type
        return Gson().fromJson(dataJsonString,dataType)
    }

}