package com.padc.shared.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padc.shared.mvp.views.BaseView


/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/22/2020.
 */
interface BasePresenter<T: BaseView> {
    fun initPresenter(view:T)
    fun onUiReady(lifecycleOwner: LifecycleOwner)
}