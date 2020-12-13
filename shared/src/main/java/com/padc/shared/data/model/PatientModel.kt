package com.padc.shared.data.model

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import com.padc.shared.data.vos.*

/**
 * Created by Phyoe Sandy Soe Tun
 * on 11/23/2020.
 */
interface PatientModel : GeneralModel {
    fun registerPatient(
        name: String,
        email: String,
        password: String,
        onSuccess: (patientId: String) -> Unit,
        onFailure: (String) -> Unit
    )

    fun login(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)

    fun broadcastConsulationRequest(
        speciality: String,
        caseSummary: List<CaseSummaryVO>,
        patient: PatientVO,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )

    fun checkOutMedicine(
        checkoutVO: CheckoutVO,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )

    fun getRecentlyConsultantDoctor(
        patientName: String,
        onSuccess: (doctorList: List<DoctorVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getDoctorsBySpeciality(
        speciality: String,
        onSuccess: (doctorList: List<DoctorVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getSpecialityListAndSaveToDb(
        onSuccess: (List<SpecialityVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getPatientsAndSaveToDb(
        id: String,
        onSuccess: (patient: PatientVO) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getGeneralQuesAndSaveToDb(
        onSuccess: (quesList: List<GeneralQuesVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getSpecialityFromDB() : LiveData<List<SpecialityVO>>

    fun getGeneralQuesFromDB() : LiveData<List<GeneralQuesVO>>

    fun getPatientByIdFromDB(id:String): LiveData<PatientVO>

    fun getPatientFromDB(): LiveData<PatientVO>

    fun getPatientByEmailFromDB(email:String): LiveData<PatientVO>

    fun getSpecialQuesFromDB() : LiveData<List<SpecialQuesVO>>

    fun getPatientbyEmailAndSaveToDb(
        email: String,
        onSuccess: (patient: PatientVO) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getSpecialQuesAndSaveToDb(
        speciality: String,
        onSuccess: (quesList: List<SpecialQuesVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun sendDirectRequest(
        patient: PatientVO,
        doctor: DoctorVO,
        caseSummaryList: List<CaseSummaryVO>,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )
}