package com.padc.shared.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.firestore.IgnoreExtraProperties

/**
 * Created by Phyoe Sandy Soe Tun
 * on 11/30/2020.
 */
@Entity(tableName = "general_question")
@IgnoreExtraProperties
data class GeneralQuesVO (
    @PrimaryKey
    var id: String = "",
    var question: String ? = "",
    var oneTime: Boolean = true
)

@Entity(tableName = "special_question")
@IgnoreExtraProperties
data class SpecialQuesVO (
    @PrimaryKey
    var id: String = "",
    var question: String ? = ""
)

@Entity(tableName = "short_question")
@IgnoreExtraProperties
data class ShortQuesVO (
    @PrimaryKey
    var id: String = "",
    var question: String ? = ""
)