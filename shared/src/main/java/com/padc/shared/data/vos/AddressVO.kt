package com.padc.shared.data.vos

import com.google.firebase.firestore.IgnoreExtraProperties

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
@IgnoreExtraProperties
data class AddressVO(
 /*   var state: String? = "",
    var township: String? = "",*/
    var id: String? = "",
    var address: String? = ""
)