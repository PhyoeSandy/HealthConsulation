package com.padc.doctor.activities

import android.os.Bundle
import com.padc.doctor.R
import com.padc.doctor.mvp.views.LoginView
import com.padc.shared.activities.BaseActivity

class LoginActivity : BaseActivity(), LoginView  {
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