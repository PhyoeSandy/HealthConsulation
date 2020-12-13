package com.padc.patient.activities

import android.os.Bundle
import com.padc.patient.R
import com.padc.patient.mvp.views.LoginView
import com.padc.patient.sharedPrefs.PatientPrefs
import com.padc.shared.activities.BaseActivity
import com.padc.shared.data.vos.PatientVO

class LoginActivity : BaseActivity(), LoginView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
    
    override fun navigateToHomeScreen() {
        startActivity(MainActivity.newIntent(this))
    }

    override fun navigateToRegisterScreen() {
        startActivity(RegisterActivity.newIntent(this))
    }
}