package com.padc.patient.mvp.presenters

import com.padc.patient.mvp.views.RegisterView
import com.padc.shared.mvp.presenters.BasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 11/28/2020.
 */
interface RegisterPresenter: BasePresenter<RegisterView> {
    fun onTapRegister(name: String, email: String, password: String)
    fun onTapLogin()
    fun onTapBack()
}