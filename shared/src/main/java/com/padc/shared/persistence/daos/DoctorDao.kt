package com.padc.shared.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padc.shared.data.vos.DoctorVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/5/2020.
 */
@Dao
interface DoctorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllDoctors(doctor: DoctorVO)

    @Query("SELECT * FROM doctor WHERE id=:id")
    fun getDoctorById(id:String) : LiveData<DoctorVO>

    //@Query("UPDATE doctor SET ")

}