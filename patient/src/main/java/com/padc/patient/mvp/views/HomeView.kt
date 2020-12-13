package com.padc.patient.mvp.views

import com.padc.shared.data.vos.DoctorVO
import com.padc.shared.data.vos.SpecialityVO
import com.padc.shared.mvp.views.BaseView

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
interface HomeView : BaseView {
    fun showSpecialityList(specialityList: List<SpecialityVO>)

    fun showRecentlyDoctor(doctorList: List<DoctorVO>)

    fun showConsulationDialog(specialityName: String)

    fun navigateToPatientInfoScreen(patientId: String) // broadcast also

}