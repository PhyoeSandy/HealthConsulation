package com.padc.shared.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padc.shared.data.vos.PatientVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/5/2020.
 */
@Dao
interface PatientDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPatient(patient: PatientVO)

    @Query("SELECT * FROM patient")
    fun getPatientList() : LiveData<PatientVO>

    @Query("SELECT * FROM patient WHERE id=:id")
    fun getPatientById(id: String) : LiveData<PatientVO>

    @Query("SELECT * FROM patient WHERE email=:email")
    fun getPatientIdByEmail(email: String) : LiveData<PatientVO>

    @Query("DELETE FROM patient")
    fun deletePatients()
}