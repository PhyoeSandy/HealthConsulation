package com.padc.shared.data.model.impl

import androidx.lifecycle.LiveData
import com.padc.shared.data.model.BaseModel
import com.padc.shared.data.model.DoctorModel
import com.padc.shared.data.vos.*
import com.padc.shared.network.impl.AuthManagerImpl
import com.padc.shared.network.impl.CloudFirestoreApiImpl
import java.util.*

/**
 * Created by Phyoe Sandy Soe Tun
 * on 11/23/2020.
 */
object DoctorModelImpl : DoctorModel, BaseModel() {
    private val mFirebaseApi = CloudFirestoreApiImpl
    private val mAuthManager = AuthManagerImpl

    override fun registerDoctor(
        name: String,
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mAuthManager.register(name, email, password, {
            var doctor = DoctorVO()
            doctor.id = UUID.randomUUID().toString()
            doctor.name = name
            doctor.email = email

            mFirebaseApi.addDoctor(doctor, {
                mDB.doctorDao().insertAllDoctors(doctor)
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

    override fun acceptRequest(
        patient: PatientVO,
        doctor: DoctorVO,
        caseSummary: List<CaseSummaryVO>,
        onSuccess: () -> Unit, onFailure: (String) -> Unit
    ) {
        mFirebaseApi.startConsulation(patient, doctor, caseSummary, onSuccess, onFailure)
    }

    override fun prescribeMedicine(
        medicine: List<MedicineVO>,
        patient: PatientVO,
        doctor: DoctorVO,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.finishConsulation(patient, medicine, doctor, onSuccess, onFailure )
    }

    /*override fun getDoctorsAndSaveToDb(
        id: String,
        onSuccess: (doctor: DoctorVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getDoctorById(id,{
            mDB.doctorDao().insertAllDoctors(it)
        }, { onFailure(it) })
    }*/

    override fun getDoctorById(id: String): LiveData<DoctorVO> {
        return mDB.doctorDao().getDoctorById(id)
    }

    override fun getShortQuesAndSaveToDb(
        speciality: String,
        onSuccess: (quesList: List<ShortQuesVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getShortQues(speciality,{
            mDB.shortQuesDao().insertAllQuestions(it)
        }, { onFailure(it) })
    }

    override fun getShortQues(): LiveData<List<ShortQuesVO>> {
        return mDB.shortQuesDao().getQuestionList()
    }

    override fun sendMessage(
        patientName: String,
        messages: ChatVO,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.addChatMessage(patientName, messages, onSuccess, onFailure)
    }

    override fun getConsulationByPatientId(
        patientId: String,
        onSuccess: (consulation:  List<ConsulationVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getConsulationsByPatientId(patientId, onSuccess, onFailure)
    }

    override fun getPrescriptionByPatientId(
        patientId: String,
        onSuccess: (medicines: List<MedicineVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getPrescriptionByPatientId(patientId, onSuccess, onFailure)
    }

    override fun getConsulationChatByPatientId(
        patientId: String,
        onSuccess: (chat: List<ChatVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getConsulationChatByPatientId(patientId,onSuccess, onFailure)
    }

    override fun getDoctorByIdFromDB(id: String): LiveData<DoctorVO> {
        return mDB.doctorDao().getDoctorById(id)
    }

    override fun addDoctorCaseSummary(
        data: TreatmentRecordVO,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.addDoctorCaseSummary(data, onSuccess, onFailure)
    }

    override fun getDoctorCaseSummaryByPatientId(id: String): LiveData<TreatmentRecordVO> {
        TODO("Not yet implemented")
    }

}