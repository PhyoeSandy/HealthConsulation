package com.padc.shared.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padc.shared.data.vos.SpecialQuesVO
import com.padc.shared.data.vos.SpecialityVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/2/2020.
 */
class SpecialQuesListTypeConverter {

    @TypeConverter
    fun toString(quesList: ArrayList<SpecialQuesVO>) : String {
        return Gson().toJson(quesList)
    }

    @TypeConverter
    fun toGenreList(genreListJsonString: String) : ArrayList<SpecialQuesVO> {
        val quesListType = object : TypeToken<ArrayList<SpecialQuesVO>>() {}.type
        return Gson().fromJson(genreListJsonString,quesListType)
    }

}