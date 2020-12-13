package com.padc.shared.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.firestore.IgnoreExtraProperties

/**
 * Created by Phyoe Sandy Soe Tun
 * on 11/30/2020.
 */
@IgnoreExtraProperties
@Entity(tableName = "chat_room")
data class ChatVO(
    @PrimaryKey
    var id: String = "",
    var sendBy: SenderVO? = null,
    var image: String? = "",
    var text: String? = "",
    var sendAt: String? = ""
)

@IgnoreExtraProperties
data class SenderVO(
    var name: String? = "",
    var speciality: String? = "",
    var image: String? = "",
    var isPatient: Boolean = false
)