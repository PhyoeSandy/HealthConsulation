package com.padc.shared.data.model.impl

import androidx.lifecycle.LiveData
import com.padc.shared.data.model.BaseModel
import com.padc.shared.data.model.PatientModel
import com.padc.shared.data.vos.*
import com.padc.shared.network.impl.AuthManagerImpl
import com.padc.shared.network.impl.CloudFirestoreApiImpl
import java.util.*

/**
 * Created by Phyoe Sandy Soe Tun
 * on 11/23/2020.
 */
object PatientModelImpl : PatientModel, BaseModel() {
    private var mAuthManager = AuthManagerImpl
    private var mFirebaseApi = CloudFirestoreApiImpl

    override fun registerPatient(
        name: String,
        email: String,
        password: String,
        onSuccess: (patientId: String) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mAuthManager.register(name, email, password, {
            var patient = PatientVO()
            patient.id = UUID.randomUUID().toString()
            patient.name = name
            patient.email = email

            mFirebaseApi.addPatient(patient, {
                mDB.patientDao().deletePatients()
                mDB.patientDao().insertPatient(patient)
                onSuccess(patient.id.toString())
            }, {
                onFailure(it)
            })
        },
            {
                onFailure(it)
            })
    }

    override fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mAuthManager.login(email, password, onSuccess, onFailure)
    }

    override fun getSpecialityListAndSaveToDb(
        onSuccess: (List<SpecialityVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getSpeciality({
            mDB.specialityDao().insertAllSpeciality(it)
        }, onFailure)
    }

    override fun broadcastConsulationRequest(
        speciality: String, caseSummary: List<CaseSummaryVO>, patient: PatientVO,
        onSuccess: () -> Unit, onFailure: (String) -> Unit
    ) {
        mFirebaseApi.addConsulationRequest(speciality, caseSummary, patient, onSuccess, onFailure)
    }

    override fun checkOutMedicine(
        checkoutVO: CheckoutVO,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.addCheckout(checkoutVO, onSuccess, onFailure)
    }

    override fun getRecentlyConsultantDoctor(
        patientId: String,
        onSuccess: (doctorList: List<DoctorVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getRecentlyDoctor(patientId, onSuccess, onFailure)
    }

    override fun getDoctorsBySpeciality(
        speciality: String,
        onSuccess: (doctorList: List<DoctorVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getDoctorsBySpeciality(speciality, onSuccess, onFailure)
    }

    override fun getPatientsAndSaveToDb(
        id: String,
        onSuccess: (patient: PatientVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getPatientbyEmail(id, {
            mDB.patientDao().insertPatient(it)
        }, { onFailure(it) })
    }

    override fun getGeneralQuesAndSaveToDb(
        onSuccess: (quesList: List<GeneralQuesVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getGeneralQues({
            mDB.generalQuesDao().insertAllQuestions(it)
        }, { onFailure(it) })
    }

    override fun getSpecialityFromDB(): LiveData<List<SpecialityVO>> {
        return mDB.specialityDao().getSpecialityList()
    }

    override fun getGeneralQuesFromDB(): LiveData<List<GeneralQuesVO>> {
        return mDB.generalQuesDao().getQuestionList()
    }

    override fun getPatientByIdFromDB(id:String): LiveData<PatientVO> {
        return mDB.patientDao().getPatientById(id)
    }

    override fun getPatientFromDB(): LiveData<PatientVO> {
        return mDB.patientDao().getPatientList()
    }

    override fun getDoctorByIdFromDB(id: String): LiveData<DoctorVO> {
        return mDB.doctorDao().getDoctorById(id)
    }

    override fun addDoctorCaseSummary(
        data: TreatmentRecordVO,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.addDoctorCaseSummary(data,onSuccess, onFailure)
    }

    override fun getDoctorCaseSummaryByPatientId(id: String): LiveData<TreatmentRecordVO> {
        TODO("Not yet implemented")
    }

    override fun getPatientByEmailFromDB(email: String): LiveData<PatientVO> {
        return mDB.patientDao().getPatientIdByEmail(email)
    }

    override fun getPatientbyEmailAndSaveToDb(
        email: String,
        onSuccess: (patient: PatientVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getPatientbyEmail(email, {
            mDB.patientDao().deletePatients()
            mDB.patientDao().insertPatient(it)
        }, { onFailure(it) })
    }

    override fun getSpecialQuesAndSaveToDb(
        speciality: String,
        onSuccess: (quesList: List<SpecialQuesVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getSpecialityQues(speciality,{
            mDB.specialQuesDao().insertAllQuestions(it)
        }, { onFailure(it) })
    }

    override fun getSpecialQuesFromDB(): LiveData<List<SpecialQuesVO>> {
        return mDB.specialQuesDao().getQuestionList()
    }

    override fun sendDirectRequest(
        patient: PatientVO,
        doctor: DoctorVO,
        caseSummaryList: List<CaseSummaryVO>,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.sendDirectRequest(patient, doctor, caseSummaryList, onSuccess, onFailure)
    }

    override fun sendMessage(
        patientId: String,
        messages: ChatVO,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.addChatMessage(patientId, messages, onSuccess, onFailure)
    }

    override fun getConsulationByPatientId(
        patientId: String,
        onSuccess: (consulation: List<ConsulationVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getConsulationsByPatientId(patientId, onSuccess, onFailure)
    }

    override fun getPrescriptionByPatientId(
        patientId: String,
        onSuccess: (medicines: List<MedicineVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getPrescriptionByPatientId(patientId,onSuccess, onFailure)
    }

    override fun getConsulationChatByPatientId(
        patientId: String,
        onSuccess: (chat: List<ChatVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getConsulationChatByPatientId(patientId,onSuccess, onFailure)
    }
}