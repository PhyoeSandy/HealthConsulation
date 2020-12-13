package com.padc.doctor.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import com.padc.doctor.mvp.presenters.LoginPresenter
import com.padc.doctor.mvp.views.LoginView
import com.padc.shared.data.model.DoctorModel
import com.padc.shared.data.model.impl.DoctorModelImpl
import com.padc.shared.mvp.presenters.AbstractBasePresenter
import com.padc.shared.network.impl.AuthManagerImpl

/**
 * Created by Phyoe Sandy Soe Tun
 * on 11/28/2020.
 */
class LoginPresenterImpl: LoginPresenter, AbstractBasePresenter<LoginView>() {
    var mDoctorModel = DoctorModelImpl

    override fun onTapLogin(email: String, password: String) {
        mDoctorModel.login(email,password,{
            mView?.navigateToHomeScreen()
        },{
            mView?.showErrorMessage(it)
        })
    }

    override fun onTapSignup() {
       mView?.navigateToRegisterScreen()
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {

    }
}