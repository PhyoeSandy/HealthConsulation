package com.padc.patient.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padc.patient.mvp.presenters.ConsulationPresenter
import com.padc.patient.mvp.views.ConsulationView
import com.padc.patient.sharedPrefs.PatientPrefs
import com.padc.shared.data.model.impl.PatientModelImpl
import com.padc.shared.data.vos.ChatVO
import com.padc.shared.data.vos.MedicineVO
import com.padc.shared.mvp.presenters.AbstractBasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
class ConsulationPresenterImpl: ConsulationPresenter, AbstractBasePresenter<ConsulationView>() {
    private var mPatientModel = PatientModelImpl
    private var mPatientId = PatientPrefs.patientId!!

    override fun onTapAttachment() {
        mView?.openGallery()
    }

    override fun sendMessage(patientId: String, chat: ChatVO) {
        mPatientModel.sendMessage(mPatientId, chat, {
           /* mPatientModel.getConsulationChatByPatientId(patientId, {
                mView?.showChatMessage(it[0])
            }, {})*/
        }, { mView?.showErrorMessage(it) })
    }

    override fun onTapMedicineOrder(medicineList: List<MedicineVO>) {
        mView?.navigateToCheckoutScreen(medicineList)
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        mPatientModel.getPatientByIdFromDB(mPatientId).observe(lifecycleOwner, Observer {
            mView?.showPatientDetails(it)
        })

        //chat thread & consulation snapshot

        mPatientModel.getConsulationByPatientId(mPatientId, {
            //mView?.showPatientDetails(it) // only obj
        }, {})

        mPatientModel.getConsulationChatByPatientId(mPatientId, {

        }, {})
    }
}