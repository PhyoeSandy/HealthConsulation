package com.padc.patient.mvp.views

import com.padc.shared.data.vos.ChatVO
import com.padc.shared.data.vos.MedicineVO
import com.padc.shared.data.vos.PatientVO
import com.padc.shared.mvp.views.BaseView

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
interface ConsulationView: BaseView {
    fun showPatientDetails(patient: PatientVO)

    fun openGallery()

    fun navigateToCheckoutScreen(medicineList: List<MedicineVO>)

    fun showChatMessage(msg: ChatVO)
}