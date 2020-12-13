package com.padc.shared.data.model

import android.content.Context
import com.padc.shared.persistence.db.HealthCareDB

/**
 * Created by Phyoe Sandy Soe Tun
 * on 11/27/2020.
 */
abstract class BaseModel {
    protected lateinit var mDB: HealthCareDB

    fun initDatabase(context: Context) {
        mDB = HealthCareDB.getDBInstance(context)
    }

}