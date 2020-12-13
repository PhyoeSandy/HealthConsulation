package com.padc.patient.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.padc.patient.R
import com.padc.patient.mvp.presenters.RegisterPresenter
import com.padc.shared.activities.BaseActivity

class RegisterActivity : BaseActivity() {
    
    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, RegisterActivity::class.java)
        }
    }

    private lateinit var mPresenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }
}