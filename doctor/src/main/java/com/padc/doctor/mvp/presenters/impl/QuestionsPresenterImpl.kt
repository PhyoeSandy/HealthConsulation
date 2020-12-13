package com.padc.doctor.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import com.padc.doctor.mvp.presenters.QuestionsPresenter
import com.padc.doctor.mvp.views.QuestionsView
import com.padc.shared.mvp.presenters.AbstractBasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
class QuestionsPresenterImpl: QuestionsPresenter, AbstractBasePresenter<QuestionsView>() {
    override fun onUiReady(lifecycleOwner: LifecycleOwner) {

    }
}