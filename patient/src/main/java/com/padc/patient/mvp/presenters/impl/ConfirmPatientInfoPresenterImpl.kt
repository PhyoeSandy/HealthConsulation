package com.padc.patient.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import com.padc.patient.mvp.presenters.ConfirmPatientInfoPresenter
import com.padc.patient.mvp.views.ConfirmPatientInfoView
import com.padc.shared.data.model.impl.PatientModelImpl
import com.padc.shared.data.vos.CaseSummaryVO
import com.padc.shared.data.vos.PatientVO
import com.padc.shared.mvp.presenters.AbstractBasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/7/2020.
 */
class ConfirmPatientInfoPresenterImpl: ConfirmPatientInfoPresenter, AbstractBasePresenter<ConfirmPatientInfoView>() {
    private var mPatientModel = PatientModelImpl

    override fun onTapAppointment(speciality: String, caseSummary: List<CaseSummaryVO>, patient: PatientVO) {
        /*mPatientModel.broadcastConsulationRequest(speciality,caseSummary, patient,{
            mView?.navigateToSpecialityScreen()
        },{
            mView?.showErrorMessage(it)
        })
*/

        /* mPatientModel.getDoctorsBySpeciality(mSpeciality, {
            // deviceId take ya mae & send noti
        }, {} )

        //fb >>> patient info: write


        mPatientModel.broadcastConsulationRequest(mSpeciality, patient.caseSummary, patient, {
            mView?.navigateToHomeScreen()
            }, {}
        )*/

    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        ///mPatientModel.
    }
}