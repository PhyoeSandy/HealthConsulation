package com.padc.doctor

import android.app.Application
import com.padc.shared.data.model.impl.DoctorModelImpl
import com.padc.shared.persistence.db.HealthCareDB

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
class DoctorApp : Application() {
    protected lateinit var mDB: HealthCareDB

    override fun onCreate() {
        super.onCreate()
        //DoctorPrefs.init(this)
        DoctorModelImpl.initDatabase(this)
    }
}