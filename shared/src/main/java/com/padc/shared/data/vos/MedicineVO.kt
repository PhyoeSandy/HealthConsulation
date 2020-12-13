package com.padc.shared.data.vos

/**
 * Created by Phyoe Sandy Soe Tun
 * on 11/30/2020.
 */
data class MedicineVO(
    var name: String? = "",
    var price: Int = 0,
    var quantity: Int = 0,
    var routine: RoutineVO? = null
)