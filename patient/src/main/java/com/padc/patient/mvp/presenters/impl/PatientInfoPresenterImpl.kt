package com.padc.patient.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padc.patient.mvp.presenters.PatientInfoPresenter
import com.padc.patient.mvp.views.PatientInfoView
import com.padc.patient.sharedPrefs.PatientPrefs
import com.padc.shared.data.model.impl.PatientModelImpl
import com.padc.shared.data.vos.PatientVO
import com.padc.shared.mvp.presenters.AbstractBasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
class PatientInfoPresenterImpl: PatientInfoPresenter, AbstractBasePresenter<PatientInfoView>() {
    private var mPatientModel = PatientModelImpl
    private lateinit var mLifecycleOwner: LifecycleOwner
    private var mSpeciality = PatientPrefs.speciality!!

    override fun onTapContinue() {
        mPatientModel.getSpecialQuesAndSaveToDb(mSpeciality, {}, {})

        mPatientModel.getSpecialQuesFromDB().observe(mLifecycleOwner, Observer {
            mView?.showSpecialityQuestions(it)
        })
    }

    override fun onTapMakeAppointment(patient: PatientVO) {
       mView?.navigateToConfirmInfoScreen()
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        mLifecycleOwner = lifecycleOwner

        mPatientModel.getGeneralQuesAndSaveToDb({},{})

        mPatientModel.getGeneralQuesFromDB()
            .observe(lifecycleOwner, Observer {
                //it.filter { data -> data.oneTime }
                if(PatientPrefs.dob.isEmpty() || PatientPrefs.dob.isNullOrBlank()) {
                    mView?.showAlwaysGeneralQuestions(it)
                } else {
                    mView?.showOneTimeGeneralQuestions(it)
                }
            })

        // patient info by ID

        //mPatientModel.getS
    }
}