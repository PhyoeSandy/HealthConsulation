package com.padc.shared.data.model

import androidx.lifecycle.LiveData
import com.padc.shared.data.vos.*

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/8/2020.
 */
interface GeneralModel {
    fun sendMessage(
        patientName: String,
        messages: ChatVO,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )

    fun getConsulationByPatientId(
        patientId: String,
        onSuccess: (consulation: List<ConsulationVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getPrescriptionByPatientId(
        patientId: String,
        onSuccess: (medicines: List<MedicineVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getConsulationChatByPatientId(
        patientId: String,
        onSuccess: (chat: List<ChatVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getDoctorByIdFromDB(id:String): LiveData<DoctorVO>

    fun addDoctorCaseSummary(
        data: TreatmentRecordVO,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )

    fun getDoctorCaseSummaryByPatientId(id:String) : LiveData<TreatmentRecordVO>
}