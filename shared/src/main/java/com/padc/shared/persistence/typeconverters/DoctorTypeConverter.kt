package com.padc.shared.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padc.shared.data.vos.DoctorVO
import com.padc.shared.data.vos.PatientVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/2/2020.
 */
class DoctorTypeConverter {

    @TypeConverter
    fun toString(data: DoctorVO) : String {
        return Gson().toJson(data)
    }

    @TypeConverter
    fun todata(dataJsonString: String) : DoctorVO {
        val dataType = object : TypeToken<DoctorVO>() {}.type
        return Gson().fromJson(dataJsonString,dataType)
    }

}