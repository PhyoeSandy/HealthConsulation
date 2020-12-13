package com.padc.patient.sharedPrefs

import android.content.Context
import android.content.SharedPreferences
import com.padc.patient.PatientApp
import com.padc.shared.data.vos.SpecialQuesVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/9/2020.
 */
object PatientPrefs {
    private const val PATIENT_SHARED_PREFS = "PATIENT_SHARED_PREFS"
    private const val MODE = Context.MODE_PRIVATE

    private const val SHARED_PREFS_PATIENT_ID = "SHARED_PREFS_PATIENT_ID"
    private const val SHARED_PREFS_PATIENT_NAME = "SHARED_PREFS_PATIENT_NAME"
    private const val SHARED_PREFS_SPECIALITY = "SHARED_PREFS_SPECIALITY"
    private const val SHARED_PREFS_DOB = "SHARED_PREFS_DOB"
    private const val SHARED_PREFS_ADDRESS = "SHARED_PREFS_ADDRESS"
    private const val SHARED_PREFS_BLOOD_TYPE = "SHARED_PREFS_BLOOD_TYPE"
    private const val SHARED_PREFS_ALLEGIC = "SHARED_PREFS_ALLEGIC"
    private const val SHARED_PREFS_WEIGHT = "SHARED_PREFS_WEIGHT"
    private const val SHARED_PREFS_HEIGHT = "SHARED_PREFS_HEIGHT"
    private const val SHARED_PREFS_BLOOD_PRESSURE = "SHARED_PREFS_BLOOD_PRESSURE"

    private lateinit var prefs: SharedPreferences

    fun init(context: Context) {
        prefs = context.getSharedPreferences(PATIENT_SHARED_PREFS, MODE)
    }

    /**
     * SharedPreferences extension function, so we won't need to call edit() and apply()
     * ourselves on every SharedPreferences operation.
     */
    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var patientId: String
        // custom getter to get a preference of a desired type, with a predefined default value
        get() = prefs.getString(SHARED_PREFS_PATIENT_ID, "").toString()
        // custom setter to save a preference back to preferences file
        set(value) = prefs.edit {
            it.putString(SHARED_PREFS_PATIENT_ID, value)
        }

    var name:String
        get() = prefs.getString(SHARED_PREFS_PATIENT_NAME, "").toString()
        set(value) = prefs.edit {
            it.putString(SHARED_PREFS_PATIENT_NAME, value)
        }

    var dob:String
        get() = prefs.getString(SHARED_PREFS_DOB, "").toString()
        set(value) = prefs.edit {
            it.putString(SHARED_PREFS_DOB, value)
        }

    var height:String
        get() = prefs.getString(SHARED_PREFS_HEIGHT, "").toString()
        set(value) = prefs.edit {
            it.putString(SHARED_PREFS_HEIGHT, value)
        }

    var weight:String
        get() = prefs.getString(SHARED_PREFS_WEIGHT, "").toString()
        set(value) = prefs.edit {
            it.putString(SHARED_PREFS_WEIGHT, value)
        }

    var illegic:String
        get() = prefs.getString(SHARED_PREFS_ALLEGIC, "").toString()
        set(value) = prefs.edit {
            it.putString(SHARED_PREFS_ALLEGIC, value)
        }

    var bloodType:String
        get() = prefs.getString(SHARED_PREFS_BLOOD_TYPE, "").toString()
        set(value) = prefs.edit {
            it.putString(SHARED_PREFS_BLOOD_TYPE, value)
        }

    var bloodPressure: String
    get() = prefs.getString(SHARED_PREFS_BLOOD_PRESSURE,"").toString()
    set(value) = prefs.edit {
        it.putString(SHARED_PREFS_BLOOD_PRESSURE,value)
    }

    var speciality: String
        get() = prefs.getString(SHARED_PREFS_SPECIALITY,"").toString()
        set(value) = prefs.edit {
            it.putString(SHARED_PREFS_SPECIALITY,value)
        }


}