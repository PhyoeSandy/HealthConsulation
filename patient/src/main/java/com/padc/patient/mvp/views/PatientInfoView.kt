package com.padc.patient.mvp.views

import com.padc.shared.data.vos.GeneralQuesVO
import com.padc.shared.data.vos.SpecialQuesVO
import com.padc.shared.mvp.views.BaseView

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
interface PatientInfoView: BaseView {
    fun showOneTimeGeneralQuestions(quesList: List<GeneralQuesVO>) // filled data par ya mae

    fun showAlwaysGeneralQuestions(quesList: List<GeneralQuesVO>)

    fun showSpecialityQuestions(quesList: List<SpecialQuesVO>)

    fun navigateToHomeScreen()

    fun navigateToConfirmInfoScreen()

}