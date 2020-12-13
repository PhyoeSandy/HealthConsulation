package com.padc.shared.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.padc.shared.persistence.typeconverters.AddressListTypeConverter
import com.padc.shared.persistence.typeconverters.CasesummaryListTypeConverter
import com.padc.shared.persistence.typeconverters.RecentlyDocListTypeConverter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 11/30/2020.
 */
@Entity(tableName = "patient")
data class PatientVO(
    @PrimaryKey
    var id: String = "",
    var name: String? = "",
    var email: String? = "",
    var password: String? = "",
    var phno: String? = "",
    var image: String? = "",
    var deviceId: String? = "",
    var address: ArrayList<AddressVO> = arrayListOf(),
    var dob: String? = "",
    var bloodType: String? = "",
    var bloodPressure: String? = "",
    var height: String? = "",
    var weight: String? = "",
    var allegicReaction: String? = "",
    var caseSummary: ArrayList<CaseSummaryVO> = arrayListOf(),
    var recentlyDoctor: ArrayList<DoctorVO> = arrayListOf()
)