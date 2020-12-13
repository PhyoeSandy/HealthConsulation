package com.padc.shared.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.firestore.IgnoreExtraProperties

/**
 * Created by Phyoe Sandy Soe Tun
 * on 11/30/2020.
 */
@Entity(tableName = "doctor")
@IgnoreExtraProperties
data class DoctorVO (
    @PrimaryKey
    var id: String = "",
    var name: String? = "",
    var email: String? = "",
    var password: String? = "",
    var degree: String? = "",
    var biography: String? = "",
    var image: String? = "",
    var speciality: String? = "",
    var deviceId: String? = ""
)