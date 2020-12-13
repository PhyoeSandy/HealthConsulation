package com.padc.shared.data.model

import androidx.lifecycle.LiveData
import com.padc.shared.data.vos.*

/**
 * Created by Phyoe Sandy Soe Tun
 * on 11/23/2020.
 */
interface DoctorModel : GeneralModel  {
    fun registerDoctor(
        name: String,
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )

    fun login(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)

    fun acceptRequest(
        patient: PatientVO,
        doctor: DoctorVO,
        caseSummary: List<CaseSummaryVO>,
        onSuccess: () -> Unit, onFailure: (String) -> Unit
    )

    /*fun postponeRequest()

    fun callYouBackRequest()*/

    fun prescribeMedicine(
        medicineList: List<MedicineVO>,
        patient: PatientVO,
        doctor: DoctorVO,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )

   /* fun getDoctorsAndSaveToDb(
        id: String,
        onSuccess: (doctor: DoctorVO) -> Unit,
        onFailure: (String) -> Unit
    )*/

    fun getDoctorById(id:String) : LiveData<DoctorVO>

    fun getShortQuesAndSaveToDb(
        speciality: String,
        onSuccess: (quesList: List<ShortQuesVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getShortQues() : LiveData<List<ShortQuesVO>>

}