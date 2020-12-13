package com.padc.shared.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padc.shared.data.vos.SpecialQuesVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/5/2020.
 */
@Dao
interface SpeciallQuesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllQuestions(specialityList: List<SpecialQuesVO>)

    @Query("SELECT * FROM special_question")
    fun getQuestionList() : LiveData<List<SpecialQuesVO>>
}