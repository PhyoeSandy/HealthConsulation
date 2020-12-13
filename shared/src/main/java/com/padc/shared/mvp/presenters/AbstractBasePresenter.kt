package com.padc.shared.mvp.presenters

import androidx.lifecycle.ViewModel
import com.padc.shared.mvp.views.BaseView

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/22/2020.
 */
abstract class AbstractBasePresenter<T: BaseView> : BasePresenter<T>, ViewModel() {

    protected var mView: T ?= null

    override fun initPresenter(view: T) {
        mView = view
    }
}