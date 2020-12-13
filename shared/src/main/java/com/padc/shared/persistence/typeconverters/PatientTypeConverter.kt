package com.padc.shared.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padc.shared.data.vos.PatientVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/2/2020.
 */
class PatientTypeConverter {

    @TypeConverter
    fun toString(data: PatientVO) : String {
        return Gson().toJson(data)
    }

    @TypeConverter
    fun todata(dataJsonString: String) : PatientVO {
        val dataType = object : TypeToken<PatientVO>() {}.type
        return Gson().fromJson(dataJsonString,dataType)
    }

}