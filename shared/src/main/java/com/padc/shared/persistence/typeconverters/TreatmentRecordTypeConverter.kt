package com.padc.shared.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padc.shared.data.vos.PatientVO
import com.padc.shared.data.vos.TreatmentRecordVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/2/2020.
 */
class TreatmentRecordTypeConverter {

    @TypeConverter
    fun toString(data: TreatmentRecordVO) : String {
        return Gson().toJson(data)
    }

    @TypeConverter
    fun todata(dataJsonString: String) : TreatmentRecordVO {
        val dataType = object : TypeToken<TreatmentRecordVO>() {}.type
        return Gson().fromJson(dataJsonString,dataType)
    }

}