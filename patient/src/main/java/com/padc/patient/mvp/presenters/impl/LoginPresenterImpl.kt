package com.padc.patient.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padc.patient.mvp.presenters.LoginPresenter
import com.padc.patient.mvp.views.LoginView
import com.padc.shared.data.model.impl.PatientModelImpl
import com.padc.shared.mvp.presenters.AbstractBasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 11/28/2020.
 */
class LoginPresenterImpl: LoginPresenter, AbstractBasePresenter<LoginView>() {
    var mPatientModel = PatientModelImpl
    lateinit var mLifecycleOwner: LifecycleOwner

    override fun onTapLogin(email: String, password: String) {
        mPatientModel.login(email, password,{
            mPatientModel.getPatientbyEmailAndSaveToDb(email, {}, {})

            mPatientModel.getPatientByEmailFromDB(email)
                .observe(mLifecycleOwner, Observer {
                    mView?.navigateToHomeScreen()
                })
        },{
            mView?.showErrorMessage(it)
        })
    }

    override fun onTapSignup() {
       mView?.navigateToRegisterScreen()
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        mLifecycleOwner = lifecycleOwner
    }
}