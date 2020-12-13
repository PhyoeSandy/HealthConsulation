package com.padc.patient.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padc.patient.mvp.presenters.HomePresenter
import com.padc.patient.mvp.views.HomeView
import com.padc.patient.sharedPrefs.PatientPrefs
import com.padc.shared.data.model.impl.PatientModelImpl
import com.padc.shared.data.vos.PatientVO
import com.padc.shared.mvp.presenters.AbstractBasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
class HomePresenterImpl : HomePresenter, AbstractBasePresenter<HomeView>() {
    private var mPatientModel = PatientModelImpl
    //private var mPatientId = PatientPrefs.patientId
    private var mPatientVO = PatientVO()
    private lateinit var mLifeCycleOwner: LifecycleOwner

    override fun onTapSpeciality(specialityName: String) {
        mView?.showConsulationDialog(specialityName)
    }

    override fun onTapRecentDoctor(doctorId: String) {
        mPatientModel.getDoctorByIdFromDB(doctorId).observe(mLifeCycleOwner, Observer {
            mPatientModel.sendDirectRequest(mPatientVO, it, mPatientVO.caseSummary ,
                {}, { mView?.showErrorMessage(it) })
        })
    }

    override fun onTapConfirm() {
        //mView?.navigateToPatientInfoScreen(mPatientId)
    }

    override fun onTapStartConsultation() {
        //mPatientModel.con   add consulation request
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        mLifeCycleOwner = lifecycleOwner

        mPatientModel.getPatientFromDB().observe(lifecycleOwner, Observer {

        })

        mPatientModel.getSpecialityListAndSaveToDb({}, {})

        mPatientModel.getSpecialityFromDB().observe(lifecycleOwner, Observer {
                mView?.showSpecialityList(it)
            })

       /* mPatientModel.getRecentlyConsultantDoctor(mPatientId,{
            mView?.showRecentlyDoctor(it)
        },{
            mView?.showErrorMessage(it)
        })

        mPatientModel.getPatientByIdFromDB(mPatientId).observe(lifecycleOwner, Observer {
                mPatientVO = it
            })*/
    }
}