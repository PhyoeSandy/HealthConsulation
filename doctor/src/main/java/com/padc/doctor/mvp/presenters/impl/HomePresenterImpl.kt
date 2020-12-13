package com.padc.doctor.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import com.padc.doctor.mvp.presenters.HomePresenter
import com.padc.doctor.mvp.views.HomeView
import com.padc.doctor.sharedPrefs.DoctorPrefs
import com.padc.shared.data.model.DoctorModel
import com.padc.shared.data.model.impl.DoctorModelImpl
import com.padc.shared.data.vos.DoctorVO
import com.padc.shared.mvp.presenters.AbstractBasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
class HomePresenterImpl: HomePresenter, AbstractBasePresenter<HomeView>() {
    private var mDoctorModel = DoctorModelImpl

    override fun onTapProfile(doctorId: String) {
        mView?.navigateToProfileScreen(doctorId)
    }

    override fun onTapSkip() {
    }

    override fun onTapAccept() {
        // consulation write
        mView?.navigateToConsulatinScreen(DoctorPrefs.doctorId)
    }

    override fun onTapPickTime() {
        mView?.showPickTimeDialog()
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        mDoctorModel.getConsulationByPatientId("",{
            mView?.showConsulationHistory(it) //
        }, {})

        // mDoctorModel.              consulation request take
    }
}