package com.padc.doctor.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.padc.doctor.R
import com.padc.doctor.mvp.presenters.LoginPresenter
import com.padc.doctor.mvp.presenters.RegisterPresenter
import com.padc.doctor.mvp.presenters.impl.RegisterPresenterImpl
import com.padc.doctor.mvp.views.RegisterView
import com.padc.shared.activities.BaseActivity

class RegisterActivity : BaseActivity(), RegisterView {
    
    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, RegisterActivity::class.java)
        }
    }

    private lateinit var mPresenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mPresenter = getPresenter<RegisterPresenterImpl, RegisterView>()
        mPresenter.onUiReady(this)
    }

    override fun navigateToLoginScreen(patientId: String) {

    }
}