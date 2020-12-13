package com.padc.shared.network.impl

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.gson.Gson
import com.padc.shared.data.vos.*
import com.padc.shared.extensions.NO_INTERNET
import com.padc.shared.network.FirebaseApi
import java.util.*

/**
 * Created by Phyoe Sandy Soe Tun
 * on 11/23/2020.
 */
object CloudFirestoreApiImpl : FirebaseApi {
    private val storage = FirebaseStorage.getInstance().reference
    private val db = Firebase.firestore

    override fun getSpeciality(
        onSuccess: (categoryList: List<SpecialityVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("speciality")
            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: NO_INTERNET)
                } ?: kotlin.run {
                    val specialityList: MutableList<SpecialityVO> = arrayListOf()
                    val result = value?.documents ?: arrayListOf()
                    for (document in result) {
                        val hashmap = document.data
                        hashmap?.put("id", document.id.toString())
                        val Data = Gson().toJson(hashmap)
                        val docsData = Gson().fromJson<SpecialityVO>(Data, SpecialityVO::class.java)

                        specialityList.add(docsData)
                    }
                    onSuccess(specialityList)
                }
            }
    }

    override fun getSpecialityQues(
        specilatyName: String,
        onSuccess: (quesList: List<SpecialQuesVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("speciality/${specilatyName}/specialityQuestion")
            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: NO_INTERNET)
                } ?: kotlin.run {
                    val questionsList: MutableList<SpecialQuesVO> = arrayListOf()
                    val result = value?.documents ?: arrayListOf()

                    for (document in result) {
                        val hashmap = document.data
                        hashmap?.put("id", document.id.toString())
                        val Data = Gson().toJson(hashmap)
                        val docsData = Gson().fromJson<SpecialQuesVO>(Data, SpecialQuesVO::class.java)

                        questionsList.add(docsData)
                    }
                    onSuccess(questionsList)
                }
            }
    }



    override fun getShortQues(
        specilatyName: String,
        onSuccess: (quesList: List<ShortQuesVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("speciality/${specilatyName}/shortQuestion")
            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: NO_INTERNET)
                } ?: kotlin.run {
                    val questionsList: MutableList<ShortQuesVO> = arrayListOf()
                    val result = value?.documents ?: arrayListOf()

                    for (document in result) {
                        val hashmap = document.data
                        hashmap?.put("id", document.id.toString())
                        val Data = Gson().toJson(hashmap)
                        val docsData = Gson().fromJson<ShortQuesVO>(Data, ShortQuesVO::class.java)

                        questionsList.add(docsData)
                    }
                    onSuccess(questionsList)
                }
            }
    }

    override fun getGeneralQues(
        onSuccess: (quesList: List<GeneralQuesVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("generalQuesTemplate")
            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: NO_INTERNET)
                } ?: kotlin.run {
                    val questionsList: MutableList<GeneralQuesVO> = arrayListOf()
                    val result = value?.documents ?: arrayListOf()

                    for (document in result) {
                        val hashmap = document.data
                        hashmap?.put("id", document.id.toString())
                        val Data = Gson().toJson(hashmap)
                        val docsData = Gson().fromJson<GeneralQuesVO>(Data, GeneralQuesVO::class.java)

                        questionsList.add(docsData)
                    }
                    onSuccess(questionsList)
                }
            }
    }

    override fun getConsulationsByPatientId(
        patientId: String,
        onSuccess: (consulation: List<ConsulationVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {

        /*
        var consulationData = ConsulationVO()
        db.collection("consulation/${patientId}/caseSummary")
                .get()
                .addOnSuccessListener { result ->
                    val list: MutableList<CaseSummaryVO> = arrayListOf()
                    for (document in result) {
                        val hashmap = document.data
                        hashmap?.put("id", document.id.toString())
                        val Data = Gson().toJson(hashmap)
                        val docsData =
                            Gson().fromJson<CaseSummaryVO>(Data, CaseSummaryVO::class.java)
                        list.add(docsData)
                    }
                    consulationData.caseSummary.addAll(list)*/

        db.collection("consulation/${patientId}")
            .whereEqualTo("finishStatus", true)
            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: NO_INTERNET)
                } ?: kotlin.run {
                    val consulationList: MutableList<ConsulationVO> = arrayListOf()
                    val result = value?.documents ?: arrayListOf()

                    for (document in result) {
                        val hashmap = document.data
                        hashmap?.put("id", document.id.toString())
                        val Data = Gson().toJson(hashmap)
                        val docsData =
                            Gson().fromJson<ConsulationVO>(Data, ConsulationVO::class.java)
                        consulationList.add(docsData)
                    }
                    onSuccess(consulationList)
                }
            }
    }

    override fun getPrescriptionByPatientId(
        patientId: String,
        onSuccess: (medicines: List<MedicineVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("consulation/${patientId}/prescription")
            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: NO_INTERNET)
                } ?: kotlin.run {
                    val list: MutableList<MedicineVO> = arrayListOf()
                    val result = value?.documents ?: arrayListOf()

                    for (document in result) {
                        val hashmap = document.data
                        hashmap?.put("id", document.id.toString())
                        val Data = Gson().toJson(hashmap)
                        val docsData = Gson().fromJson<MedicineVO>(Data, MedicineVO::class.java)
                        list.add(docsData)
                    }
                    onSuccess(list)
                }
            }
    }

    override fun getConsulationChatByPatientId(
        patientId: String,
        onSuccess: (chat: List<ChatVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("consulation/${patientId}/chat")
            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: NO_INTERNET)
                } ?: kotlin.run {
                    val list: MutableList<ChatVO> = arrayListOf()
                    val result = value?.documents ?: arrayListOf()

                    for (document in result) {
                        val hashmap = document.data
                        hashmap?.put("id", document.id.toString())
                        val Data = Gson().toJson(hashmap)
                        val docsData = Gson().fromJson<ChatVO>(Data, ChatVO::class.java)
                        list.add(docsData)
                    }
                    onSuccess(list)
                }
            }
    }

    override fun getCheckoutMedicine(
        documentId: String,
        onSuccess: (checkoutVO: CheckoutVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val checkOutData = CheckoutVO()
        db.collection("checkOut/${documentId}/prescription")
            .get()
            .addOnSuccessListener { result ->
                val list: MutableList<MedicineVO> = arrayListOf()
                for (document in result) {
                    val hashmap = document.data
                    hashmap?.put("id", document.id.toString())
                    val Data = Gson().toJson(hashmap)
                    val docsData = Gson().fromJson<MedicineVO>(Data, MedicineVO::class.java)
                    list.add(docsData)
                }
                checkOutData.prescription.addAll(list)

                db.collection("checkOut")
                    .document(documentId)
                    .addSnapshotListener { value, error ->
                        error?.let {
                            onFailure(it.message ?: NO_INTERNET)
                        } ?: kotlin.run {
                            val data = value?.data
                            checkOutData.patient = data?.get("patient") as PatientVO
                            checkOutData.prescription =
                                data["prescription"] as ArrayList<MedicineVO>
                            checkOutData.address = data["address"] as AddressVO
                            checkOutData.total = data["total"] as Int

                            onSuccess(checkOutData)
                        }
                    }
            }
    }

    override fun getPatientbyEmail(
        email: String,
        onSuccess: (patient: PatientVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("patient")
            .whereEqualTo("email",email)
            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: NO_INTERNET)
                } ?: kotlin.run {
                    val list: MutableList<PatientVO> = arrayListOf()
                    val result = value?.documents ?: arrayListOf()

                    for (document in result) {
                        val hashmap = document.data
                        hashmap?.put("id", document.id.toString())
                        val Data = Gson().toJson(hashmap)
                        val docsData = Gson().fromJson<PatientVO>(Data, PatientVO::class.java)
                        list.add(docsData)
                    }
                    onSuccess(list[0])
                }
            }
    }

    override fun getDoctorByEmail(
        email: String,
        onSuccess: (doctor: DoctorVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("doctor")
            .whereEqualTo("email",email)
            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: NO_INTERNET)
                } ?: kotlin.run {
                    val list: MutableList<DoctorVO> = arrayListOf()
                    val result = value?.documents ?: arrayListOf()

                    for (document in result) {
                        val hashmap = document.data
                        hashmap?.put("id", document.id.toString())
                        val Data = Gson().toJson(hashmap)
                        val docsData = Gson().fromJson<DoctorVO>(Data, DoctorVO::class.java)
                        list.add(docsData)
                    }
                    onSuccess(list[0])
                }
            }
    }

    override fun getRecentlyDoctor(
        patientId: String,
        onSuccess: (doctorList: List<DoctorVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("patient/${patientId}/recentlyDoctor")
            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: NO_INTERNET)
                } ?: kotlin.run {
                    val doctorList: MutableList<DoctorVO> = arrayListOf()
                    val result = value?.documents ?: arrayListOf()

                    for (document in result) {
                        val data = document.data
                        var doctors = DoctorVO()
                        doctors.name = data?.get("name") as String
                        doctors.email = data["email"] as String
                        doctors.password = data["password"] as String
                        doctors.degree = data["degree"] as String
                        doctors.biography = data["biography"] as String
                        doctors.image = data["image"] as String
                        doctors.biography = data["biography"] as String
                        doctors.speciality = data["speciality"] as String

                        doctorList.add(doctors)
                    }
                    onSuccess(doctorList)
                }
            }
    }

    override fun getDoctorsBySpeciality(
        speciality: String,
        onSuccess: (doctorList: List<DoctorVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("doctor")
            .whereEqualTo("speciality", speciality)
            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: NO_INTERNET)
                } ?: kotlin.run {
                    val doctorList: MutableList<DoctorVO> = arrayListOf()
                    val result = value?.documents ?: arrayListOf()

                    for (document in result) {
                        val hashmap = document.data
                        hashmap?.put("id", document.id.toString())
                        val Data = Gson().toJson(hashmap)
                        val docsData = Gson().fromJson<DoctorVO>(Data, DoctorVO::class.java)

                        doctorList.add(docsData)
                    }
                    onSuccess(doctorList)
                }
            }
    }

    override fun sendDirectRequest(
        patient: PatientVO,
        doctor: DoctorVO,
        caseSummaryList: List<CaseSummaryVO>,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        val consulationRequest = hashMapOf(
            "caseSummary" to caseSummaryList,
            "patient" to patient,
            "doctor" to doctor
        )
        db.collection("consulationRequest")
            .add(consulationRequest)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener {
                onFailure("Consulation Request fail")
            }
    }

    override fun startConsulation(
        patient: PatientVO,
        doctor: DoctorVO,
        caseSummaryList: List<CaseSummaryVO>,
        onSuccess: () -> Unit, onFailure: (String) -> Unit
    ) {
        val consulationMap = hashMapOf(
            "caseSummary" to caseSummaryList,
            "patient" to patient,
            "doctor" to doctor
        )
        db.collection("consulation")
            .document(UUID.randomUUID().toString())
            .set(consulationMap)
            .addOnSuccessListener {
                onSuccess()

                db.collection("consulation/${patient.id}/caseSummary")
                    .add(caseSummaryList)
                    .addOnSuccessListener {
                        onSuccess()
                        Log.d("Success", "Successfully added Casesummary")
                    }
                    .addOnFailureListener {
                        onFailure("Failed to add Casesummary")
                        Log.d("Failure", "Failed to add Casesummary")
                    }

                Log.d("Success", "Successfully added Consulation")
            }
            .addOnFailureListener {
                onFailure("Order fail")
                Log.d("Failure", "Failed to add Consulation")
            }
    }

    override fun addConsulationRequest(
        speciality: String,
        caseSummary: List<CaseSummaryVO>,
        patient: PatientVO,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        val consulationRequest = hashMapOf(
            "caseSummary" to caseSummary,
            "speciality" to speciality,
            "patient" to patient
        )
        db.collection("consulationRequest")
            .add(consulationRequest)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener {
                onFailure("Consulation Request fail")
            }
    }

    override fun addChatMessage(
        patientId: String,
        messages: ChatVO,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("consulation/$patientId/chat")
            .document(UUID.randomUUID().toString())
            .set(messages)
            .addOnSuccessListener { Log.d("Success", "Chat Successfully ") }
            .addOnFailureListener { Log.d("Failure", "Chat Failed") }
    }

    override fun addCheckout(
        checkoutVO: CheckoutVO,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("checkOut")
            .document(UUID.randomUUID().toString())
            .set(checkoutVO)
            .addOnSuccessListener { Log.d("Success", "Checkout added Successfully ") }
            .addOnFailureListener { Log.d("Failure", "Checkout added Failed") }
    }

    override fun addDoctor(doctor: DoctorVO, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        db.collection("doctor")
            .document(doctor.id.toString())
            .set(doctor)
            .addOnSuccessListener {
                onSuccess()
                Log.d("Success", "Successfully added Doctor")
            }
            .addOnFailureListener {
                onFailure("Doctor add fail")
                Log.d("Failure", "Failed to add Doctor")
            }
    }

    override fun addPatient(
        patient: PatientVO,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("patient")
            .document(patient.id.toString())
            .set(patient)
            .addOnSuccessListener {
                onSuccess()
                Log.d("Success", "Successfully added Paient")
            }
            .addOnFailureListener {
                onFailure("Paient add fail")
                Log.d("Failure", "Failed to add Paient")
            }
    }

    override fun addDoctorCaseSummary(
        data: TreatmentRecordVO,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("consulation/${data.patientId}/medicalRecord")
            .document(UUID.randomUUID().toString())
            .set(data)
            .addOnSuccessListener { Log.d("Success", "Chat Successfully ") }
            .addOnFailureListener { Log.d("Failure", "Chat Failed") }
    }

    override fun finishConsulation(
        patient: PatientVO,
        medicineList: List<MedicineVO>,
        doctor: DoctorVO,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        val consultationChatMap = hashMapOf(
            "finishStatus" to true)

        db.collection("consultation")
            .document(patient.id.toString())
            .set(consultationChatMap)
            .addOnSuccessListener { Log.d("Success", "Successfully ") }
            .addOnFailureListener { Log.d("Failure", "Failed") }

        /*getConsulationsByPatientName(patient.id.toString(), { consulation ->
            for (medicine in medicineList) {
                db.collection("consulation/${patient.id}/prescription")
                    .document(medicine.name.toString())
                    .set(medicine)
                    .addOnSuccessListener { Log.d("Success", "Prescription Successfully ") }
                    .addOnFailureListener { Log.d("Failure", "Prescription Failed") }
            }
            consulation.finishStatus = true
        }, {
            Log.d("consulation", "failed")
        })*/

        db.collection("patient/${patient.id}/recentlyDoctor")
            .document(UUID.randomUUID().toString())
            .set(doctor)
            .addOnSuccessListener { Log.d("Success", "RecentlyDoctor added Successfully ") }
            .addOnFailureListener { Log.d("Failure", "RecentlyDoctor added Failed") }
    }

}