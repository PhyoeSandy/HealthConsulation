package com.padc.doctor.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import com.padc.doctor.mvp.presenters.PrescribeMedicinePresenter
import com.padc.doctor.mvp.views.PrescribeMedicineView
import com.padc.shared.mvp.presenters.AbstractBasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
class PrescribeMedicinePresenterImpl: PrescribeMedicinePresenter, AbstractBasePresenter<PrescribeMedicineView>() {
    override fun onUiReady(lifecycleOwner: LifecycleOwner) {

    }
}