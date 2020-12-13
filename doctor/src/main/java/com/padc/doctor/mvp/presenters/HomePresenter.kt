package com.padc.doctor.mvp.presenters

import com.padc.doctor.mvp.views.HomeView
import com.padc.shared.data.vos.DoctorVO
import com.padc.shared.mvp.presenters.BasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
interface HomePresenter: BasePresenter<HomeView> {
    fun onTapProfile(doctorId: String)

    fun onTapSkip()

    fun onTapAccept()

    fun onTapPickTime()
}