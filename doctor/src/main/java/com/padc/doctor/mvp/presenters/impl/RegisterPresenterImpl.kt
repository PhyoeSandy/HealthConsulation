package com.padc.doctor.mvp.presenters.impl

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import com.padc.doctor.mvp.presenters.RegisterPresenter
import com.padc.doctor.mvp.views.RegisterView
import com.padc.shared.data.model.impl.DoctorModelImpl
import com.padc.shared.mvp.presenters.AbstractBasePresenter
import java.util.*

/**
 * Created by Phyoe Sandy Soe Tun
 * on 11/28/2020.
 */
class RegisterPresenterImpl: RegisterPresenter, AbstractBasePresenter<RegisterView>() {
    private var mDoctorModel = DoctorModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        mDoctorModel.registerDoctor("PSST","ps@gmail.com","123456",{


        },{
        })
    }
}