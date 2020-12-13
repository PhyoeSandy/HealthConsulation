package com.padc.patient.mvp.views

import com.padc.shared.data.vos.ConsulationVO
import com.padc.shared.data.vos.MedicineVO
import com.padc.shared.data.vos.TreatmentRecordVO
import com.padc.shared.mvp.views.BaseView

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
interface AppointmentsView : BaseView {
    fun showConsulationHistory(list: List<ConsulationVO>)

    fun showPrescriptionDialog(list: List<MedicineVO>)

    fun showMedicalRecord(record: TreatmentRecordVO)

    fun hidePrescriptionDialog()
}