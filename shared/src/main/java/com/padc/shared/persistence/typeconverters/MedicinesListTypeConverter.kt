package com.padc.shared.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padc.shared.data.vos.MedicineVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/2/2020.
 */
class MedicinesListTypeConverter {

    @TypeConverter
    fun toString(medicineList: ArrayList<MedicineVO>) : String {
        return Gson().toJson(medicineList)
    }

    @TypeConverter
    fun toMedicineList(genreListJsonString: String) : ArrayList<MedicineVO> {
        val medicineListType = object : TypeToken<ArrayList<MedicineVO>>() {}.type
        return Gson().fromJson(genreListJsonString,medicineListType)
    }

}