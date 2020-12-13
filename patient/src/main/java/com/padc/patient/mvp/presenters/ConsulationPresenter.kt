package com.padc.patient.mvp.presenters

import com.padc.patient.mvp.views.ConsulationView
import com.padc.shared.data.vos.ChatVO
import com.padc.shared.data.vos.MedicineVO
import com.padc.shared.mvp.presenters.BasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
interface ConsulationPresenter : BasePresenter<ConsulationView> {

    fun onTapAttachment()

    fun sendMessage(patientId: String, chat: ChatVO)

    fun onTapMedicineOrder(medicineList: List<MedicineVO>)
}