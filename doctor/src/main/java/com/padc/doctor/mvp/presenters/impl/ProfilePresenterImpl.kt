package com.padc.doctor.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import com.padc.doctor.mvp.presenters.ProfilePresenter
import com.padc.doctor.mvp.views.ProfileView
import com.padc.shared.data.model.impl.DoctorModelImpl
import com.padc.shared.mvp.presenters.AbstractBasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
class ProfilePresenterImpl: ProfilePresenter, AbstractBasePresenter<ProfileView>() {
    private var mDoctorModel = DoctorModelImpl

    fun onUiReady(lifecycleOwner: LifecycleOwner, doctorId: String) {
        mDoctorModel.getDoctorById(doctorId)
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {

    }
}