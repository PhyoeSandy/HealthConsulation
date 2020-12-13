package com.padc.patient.mvp.presenters

import com.padc.patient.mvp.views.LoginView
import com.padc.shared.mvp.presenters.BasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 11/28/2020.
 */
interface LoginPresenter : BasePresenter<LoginView> {
    fun onTapLogin(email: String, password: String)
    fun onTapSignup()
}