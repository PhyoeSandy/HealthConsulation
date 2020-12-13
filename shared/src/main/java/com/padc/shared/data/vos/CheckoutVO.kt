package com.padc.shared.data.vos

import androidx.room.TypeConverters
import com.google.firebase.firestore.IgnoreExtraProperties
import com.padc.shared.persistence.typeconverters.MedicinesListTypeConverter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
@IgnoreExtraProperties
data class CheckoutVO (
    var patient: PatientVO?= null,
    var prescription: ArrayList<MedicineVO> = arrayListOf(),
    var total: Int = 0,
    var address: AddressVO? = null
)