package com.padc.patient.mvp.views

import com.padc.shared.mvp.views.BaseView

/**
 * Created by Phyoe Sandy Soe Tun
 * on 11/28/2020.
 */
interface RegisterView : BaseView {
    fun navigateToHomeScreen()
    fun navigateToLoginScreen()
    fun navigateBack()
}