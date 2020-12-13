package com.padc.shared.network

import com.padc.shared.data.vos.*

/**
 * Created by Phyoe Sandy Soe Tun
 * on 11/23/2020.
 */
interface FirebaseApi {
    fun getSpeciality(
        onSuccess: (categoryList: List<SpecialityVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getSpecialityQues(
        specilatyName: String,
        onSuccess: (quesList: List<SpecialQuesVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getGeneralQues(
        onSuccess: (quesList: List<GeneralQuesVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getShortQues(
        specilatyName: String,
        onSuccess: (quesList: List<ShortQuesVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getRecentlyDoctor(
        patientId: String,
        onSuccess: (doctorList: List<DoctorVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getDoctorsBySpeciality(
        speciality: String,
        onSuccess: (doctorList: List<DoctorVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun sendDirectRequest(
        patient: PatientVO,
        doctor: DoctorVO,
        caseSummaryList: List<CaseSummaryVO>,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )

    fun getConsulationsByPatientId(
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

    fun getCheckoutMedicine(
        documentId: String,
        onSuccess: (checkoutVO: CheckoutVO) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getPatientbyEmail(
        email: String,
        onSuccess: (patient: PatientVO) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getDoctorByEmail(
        email:String,
        onSuccess: (doctor: DoctorVO) -> Unit,
        onFailure: (String) -> Unit
    )

    fun startConsulation(
        patient: PatientVO,
        doctor: DoctorVO,
        caseSummaryList: List<CaseSummaryVO>,
        onSuccess: () -> Unit, onFailure: (String) -> Unit
    )

    fun addConsulationRequest(
        speciality: String,
        caseSummary: List<CaseSummaryVO>,
        patient: PatientVO,
        onSuccess: () -> Unit, onFailure: (String) -> Unit
    )

    fun addChatMessage(
        patientId: String,
        chat: ChatVO,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )

    fun finishConsulation(
        patient: PatientVO,
        medicineList: List<MedicineVO>,
        doctor: DoctorVO,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )

    fun addCheckout(
        checkoutVO: CheckoutVO,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )

    fun addDoctor(
        doctor: DoctorVO,
        onSuccess: () -> Unit, onFailure: (String) -> Unit
    )

    fun addPatient(
        patient: PatientVO,
        onSuccess: () -> Unit, onFailure: (String) -> Unit
    )

     fun addDoctorCaseSummary(
        data: TreatmentRecordVO,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )


}