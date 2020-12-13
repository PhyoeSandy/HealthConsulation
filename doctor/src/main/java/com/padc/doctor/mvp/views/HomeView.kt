package com.padc.doctor.mvp.views

import com.padc.shared.data.vos.ConsulationVO
import com.padc.shared.mvp.views.BaseView

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
interface HomeView : BaseView {
    fun navigateToProfileScreen(doctorId: String)

    fun navigateToConsulatinScreen(doctorId: String)

    fun showConsulationHistory(list: List<ConsulationVO>)

    fun showPickTimeDialog()
}