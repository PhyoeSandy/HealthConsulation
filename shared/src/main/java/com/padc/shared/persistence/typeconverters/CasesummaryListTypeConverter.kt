package com.padc.shared.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padc.shared.data.vos.CaseSummaryVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/2/2020.
 */
class CasesummaryListTypeConverter {

    @TypeConverter
    fun toString(list: ArrayList<CaseSummaryVO>) : String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toCaseSummaryList(listJsonString: String) : ArrayList<CaseSummaryVO> {
        val listType = object : TypeToken<ArrayList<CaseSummaryVO>>() {}.type
        return Gson().fromJson(listJsonString,listType)
    }

}