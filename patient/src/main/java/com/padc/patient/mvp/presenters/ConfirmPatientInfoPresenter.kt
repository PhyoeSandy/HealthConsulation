package com.padc.patient.mvp.presenters

import com.padc.patient.mvp.views.ConfirmPatientInfoView
import com.padc.shared.data.vos.CaseSummaryVO
import com.padc.shared.data.vos.PatientVO
import com.padc.shared.mvp.presenters.BasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/7/2020.
 */
interface ConfirmPatientInfoPresenter : BasePresenter<ConfirmPatientInfoView> {
    fun onTapAppointment(speciality: String,caseSummary: List<CaseSummaryVO>,patient: PatientVO)



}