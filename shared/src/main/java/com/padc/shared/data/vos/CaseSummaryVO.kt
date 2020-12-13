package com.padc.shared.data.vos

import com.google.firebase.firestore.IgnoreExtraProperties

/**
 * Created by Phyoe Sandy Soe Tun
 * on 11/30/2020.
 */
@IgnoreExtraProperties
data class CaseSummaryVO (
    var question: String? = "",
    var answer: String? = ""
)