package com.padc.shared.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padc.shared.data.vos.ShortQuesVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/5/2020.
 */
@Dao
interface ShortQuesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllQuestions(specialityList: List<ShortQuesVO>)

    @Query("SELECT * FROM short_question")
    fun getQuestionList() : LiveData<List<ShortQuesVO>>
}