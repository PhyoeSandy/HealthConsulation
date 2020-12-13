package com.padc.patient.mvp.presenters

import com.padc.patient.mvp.views.AppointmentsView
import com.padc.shared.mvp.presenters.BasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
interface AppointmentsPresenter: BasePresenter<AppointmentsView> {
    fun onTapSendMessage() // doctor case summary show

    fun onTapPrescribeMedicine()

    fun onTapClose()

}