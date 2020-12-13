package com.padc.patient.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padc.patient.mvp.presenters.AppointmentsPresenter
import com.padc.patient.mvp.views.AppointmentsView
import com.padc.patient.sharedPrefs.PatientPrefs
import com.padc.shared.data.model.impl.PatientModelImpl
import com.padc.shared.mvp.presenters.AbstractBasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
class AppointmentsPresenterImpl : AppointmentsPresenter, AbstractBasePresenter<AppointmentsView>() {
    private var mPatientModel = PatientModelImpl
    private lateinit var mLifecycleOwner: LifecycleOwner

    override fun onTapSendMessage() {
        mPatientModel.getDoctorCaseSummaryByPatientId(PatientPrefs.patientId) //change param
            .observe(mLifecycleOwner, Observer {
                mView?.showMedicalRecord(it)
            })
    }

    override fun onTapPrescribeMedicine() {
        mPatientModel.getPrescriptionByPatientId(PatientPrefs.patientId, {
            mView?.showPrescriptionDialog(it)
        }, { mView?.showErrorMessage(it) })
    }

    override fun onTapClose() {
        mView?.hidePrescriptionDialog()
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        mLifecycleOwner = lifecycleOwner
        mPatientModel.getConsulationByPatientId(PatientPrefs.patientId, {

        },
        { mView?.showErrorMessage(it) })
    }
}