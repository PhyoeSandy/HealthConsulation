package com.padc.patient.mvp.presenters

import com.padc.patient.mvp.views.HomeView
import com.padc.shared.mvp.presenters.BasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
interface HomePresenter : BasePresenter<HomeView> {
    fun onTapSpeciality(specialityName: String)

    fun onTapRecentDoctor(doctorId: String)

    fun onTapConfirm()

    fun onTapStartConsultation()
}