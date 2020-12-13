package com.padc.patient.mvp.views

import com.padc.shared.data.vos.DoctorVO
import com.padc.shared.mvp.views.BaseView

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
interface ProfileView: BaseView {
    fun showDoctorProfile(doctorVO: DoctorVO)
}