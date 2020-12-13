package com.padc.doctor.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import com.padc.doctor.mvp.presenters.ConsulationPresenter
import com.padc.doctor.mvp.views.ConsulationView
import com.padc.shared.mvp.presenters.AbstractBasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
class ConsulationPresenterImpl: ConsulationPresenter, AbstractBasePresenter<ConsulationView>() {
    override fun onUiReady(lifecycleOwner: LifecycleOwner) {

    }
}