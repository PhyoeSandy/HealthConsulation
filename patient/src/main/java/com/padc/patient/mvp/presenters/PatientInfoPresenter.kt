package com.padc.patient.mvp.presenters

import com.padc.patient.mvp.views.PatientInfoView
import com.padc.shared.data.vos.PatientVO
import com.padc.shared.mvp.presenters.BasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
interface PatientInfoPresenter: BasePresenter<PatientInfoView> {
    fun onTapContinue()

    fun onTapMakeAppointment(patient: PatientVO)
}