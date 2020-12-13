package com.padc.patient.mvp.views

import com.padc.shared.mvp.views.BaseView

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/7/2020.
 */
interface ConfirmPatientInfoView : BaseView {
    fun showPatientCaseSummary()

    fun navigateToSpecialityScreen()

}