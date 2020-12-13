package com.padc.shared.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.firebase.firestore.IgnoreExtraProperties
import com.padc.shared.persistence.typeconverters.CasesummaryListTypeConverter
import com.padc.shared.persistence.typeconverters.MedicinesListTypeConverter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 11/30/2020.
 */
@Entity(tableName = "consulation")
@IgnoreExtraProperties
data class ConsulationVO(
    @PrimaryKey
    var id: String = "",
    var patient: PatientVO? = null,
    var doctor: DoctorVO? = null,
    var caseSummary: ArrayList<CaseSummaryVO> = arrayListOf(),
    var chat: ArrayList<ChatVO> = arrayListOf(),
    var prescription: ArrayList<MedicineVO> = arrayListOf(),
    var finishStatus: Boolean = false,
    var doctorCaseSummary: TreatmentRecordVO? = null
)