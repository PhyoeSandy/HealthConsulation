package com.padc.shared.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.firebase.firestore.IgnoreExtraProperties
import com.padc.shared.persistence.typeconverters.MedicinesListTypeConverter
import com.padc.shared.persistence.typeconverters.QuestionsListTypeConverter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 11/30/2020.
 */
@Entity(tableName = "speciality")
@IgnoreExtraProperties
data class SpecialityVO(
    @PrimaryKey
    var id: String = "",
    var name: String? = "",
    var image: String? = "",
    var specialityQuestion: ArrayList<SpecialQuesVO> = arrayListOf(),
    var specialityMedicine: ArrayList<MedicineVO> = arrayListOf(),
    var shortActions: ArrayList<ShortQuesVO> = arrayListOf()
)