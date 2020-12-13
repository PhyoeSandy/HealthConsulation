package com.padc.shared.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padc.shared.data.vos.GeneralQuesVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/5/2020.
 */
@Dao
interface GeneralQuesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllQuestions(specialityList: List<GeneralQuesVO>)

    @Query("SELECT * FROM general_question")
    fun getQuestionList() : LiveData<List<GeneralQuesVO>>
}