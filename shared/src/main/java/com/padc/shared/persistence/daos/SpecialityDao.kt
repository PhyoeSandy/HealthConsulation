package com.padc.shared.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padc.shared.data.vos.SpecialityVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/5/2020.
 */
@Dao
interface SpecialityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllSpeciality(specialityList: List<SpecialityVO>)

    @Query("SELECT * FROM speciality")
    fun getSpecialityList() : LiveData<List<SpecialityVO>>
}