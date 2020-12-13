package com.padc.shared.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padc.shared.data.vos.ConsulationVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
@Dao
interface ConsulationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllConsulation(consulations: List<ConsulationVO>)

    @Query("SELECT * FROM consulation")
    fun getConsulationList(consulations: LiveData<List<ConsulationVO>>)
}