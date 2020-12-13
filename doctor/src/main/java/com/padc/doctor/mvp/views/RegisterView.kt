package com.padc.doctor.mvp.views

import com.padc.shared.mvp.views.BaseView

/**
 * Created by Phyoe Sandy Soe Tun
 * on 11/28/2020.
 */
interface RegisterView : BaseView {
    fun navigateToLoginScreen(patientId: String)
}