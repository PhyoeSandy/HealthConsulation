package com.padc.patient.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import com.padc.patient.mvp.presenters.RegisterPresenter
import com.padc.patient.mvp.views.RegisterView
import com.padc.shared.data.model.impl.PatientModelImpl
import com.padc.shared.mvp.presenters.AbstractBasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 11/28/2020.
 */
class RegisterPresenterImpl: RegisterPresenter, AbstractBasePresenter<RegisterView>() {
    private var mPatientModel = PatientModelImpl

    override fun onTapRegister(name: String, email: String, password: String) {
        mPatientModel.registerPatient(name,email,password,{
            mView?.navigateToHomeScreen()
        },{
            mView?.showErrorMessage(it)
        })
    }

    override fun onTapLogin() {
        mView?.navigateToLoginScreen()
    }

    override fun onTapBack() {
        mView?.navigateBack()
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {}
}