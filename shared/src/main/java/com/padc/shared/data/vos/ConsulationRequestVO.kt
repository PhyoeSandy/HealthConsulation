package com.padc.shared.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.firestore.IgnoreExtraProperties

/**
 * Created by Phyoe Sandy Soe Tun
 * on 11/30/2020.
 */
@IgnoreExtraProperties
@Entity(tableName = "consulation_request")
data class ConsulationRequestVO(
    @PrimaryKey
    var id: String = "",
    var caseSummary: ArrayList<CaseSummaryVO> = arrayListOf(),
    var patient: PatientVO ?= null,
    var speciality: String ?= ""
)