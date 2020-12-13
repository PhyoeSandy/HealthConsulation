package com.padc.shared.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padc.shared.data.vos.ShortQuesVO
import com.padc.shared.data.vos.SpecialQuesVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/2/2020.
 */
class ShortQuesListTypeConverter {

    @TypeConverter
    fun toString(quesList: ArrayList<ShortQuesVO>) : String {
        return Gson().toJson(quesList)
    }

    @TypeConverter
    fun toShortQuesList(genreListJsonString: String) : ArrayList<ShortQuesVO> {
        val quesListType = object : TypeToken<ArrayList<ShortQuesVO>>() {}.type
        return Gson().fromJson(genreListJsonString,quesListType)
    }

}