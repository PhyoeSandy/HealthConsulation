package com.padc.patient.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import com.padc.patient.mvp.presenters.ProfilePresenter
import com.padc.patient.mvp.views.ProfileView
import com.padc.shared.data.model.impl.DoctorModelImpl
import com.padc.shared.mvp.presenters.AbstractBasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
class ProfilePresenterImpl: ProfilePresenter, AbstractBasePresenter<ProfileView>() {
    private var mDoctorModel = DoctorModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {

    }
}