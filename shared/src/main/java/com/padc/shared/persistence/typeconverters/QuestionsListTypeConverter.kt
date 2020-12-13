package com.padc.shared.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padc.shared.data.vos.SpecialityVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/2/2020.
 */
class QuestionsListTypeConverter {

    @TypeConverter
    fun toString(quesList: ArrayList<SpecialityVO>) : String {
        return Gson().toJson(quesList)
    }

    @TypeConverter
    fun toGenreList(genreListJsonString: String) : ArrayList<SpecialityVO> {
        val quesListType = object : TypeToken<ArrayList<SpecialityVO>>() {}.type
        return Gson().fromJson(genreListJsonString,quesListType)
    }

}