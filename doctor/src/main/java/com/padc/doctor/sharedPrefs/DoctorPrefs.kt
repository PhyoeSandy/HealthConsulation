package com.padc.doctor.sharedPrefs

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/9/2020.
 */
object DoctorPrefs {
    private const val DOCTOR_SHARED_PREFS = "DOCTOR_SHARED_PREFS"
    private const val MODE = Context.MODE_PRIVATE

    private const val SHARED_PREFS_DOCTOR_ID = "SHARED_PREFS_DOCTOR_ID"

    private lateinit var prefs: SharedPreferences

    fun init(context: Context) {
        prefs = context.getSharedPreferences(DOCTOR_SHARED_PREFS, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var doctorId: String
        get() = prefs.getString(SHARED_PREFS_DOCTOR_ID, "").toString()
        set(value) = prefs.edit {
            it.putString(SHARED_PREFS_DOCTOR_ID, value)
        }

}