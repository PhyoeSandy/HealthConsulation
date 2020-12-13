package com.padc.patient

import android.app.Application
import com.padc.patient.sharedPrefs.PatientPrefs
import com.padc.shared.data.model.impl.PatientModelImpl
import com.padc.shared.persistence.db.HealthCareDB

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
class PatientApp: Application() {
    protected lateinit var mDB: HealthCareDB

    override fun onCreate() {
        super.onCreate()
        PatientPrefs.init(this)
        PatientModelImpl.initDatabase(this)
    }

}