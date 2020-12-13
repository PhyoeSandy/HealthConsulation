package com.padc.shared.data.vos

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/5/2020.
 */
data class RoutineVO(
    var time: Routine? = Routine.MORNING,
    var noOfDays: Int = 0,
    var afterMeal: Boolean = false,
    //var repeat: Boolean = false,
    var comment: String? = ""
)