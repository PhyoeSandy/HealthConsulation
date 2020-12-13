package com.padc.doctor.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import com.padc.doctor.mvp.presenters.MedicalTreatmentPresenter
import com.padc.doctor.mvp.views.MedicalTreatmentView
import com.padc.shared.mvp.presenters.AbstractBasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
class MedicalTreatmentPresenterImpl : MedicalTreatmentPresenter, AbstractBasePresenter<MedicalTreatmentView>() {
    override fun onUiReady(lifecycleOwner: LifecycleOwner) {

    }
}