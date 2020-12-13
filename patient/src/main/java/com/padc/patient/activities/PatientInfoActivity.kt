package com.padc.patient.activities

import android.content.Context
import android.content.Intent
import com.padc.patient.adapters.GeneralQuesAdapter
import com.padc.patient.adapters.SpeciallQuesAdapter
import com.padc.patient.mvp.views.PatientInfoView
import com.padc.shared.activities.BaseActivity
import com.padc.shared.data.vos.GeneralQuesVO
import com.padc.shared.data.vos.SpecialQuesVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/12/2020.
 */
class PatientInfoActivity: BaseActivity(), PatientInfoView {

    private lateinit var mGeneralQuesAdapter: GeneralQuesAdapter
    private lateinit var mSpecialQuesAdapter: SpeciallQuesAdapter

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, PatientInfoActivity::class.java)
        }
    }

    override fun showOneTimeGeneralQuestions(quesList: List<GeneralQuesVO>) {
        mGeneralQuesAdapter.setNewData(quesList.toMutableList())
    }

    override fun showAlwaysGeneralQuestions(quesList: List<GeneralQuesVO>) {
        mGeneralQuesAdapter.setNewData(quesList.toMutableList())
    }

    override fun showSpecialityQuestions(quesList: List<SpecialQuesVO>) {
        mSpecialQuesAdapter.setNewData(quesList.toMutableList())
    }

    override fun navigateToHomeScreen() {

    }

    override fun navigateToConfirmInfoScreen() {
        TODO("Not yet implemented")
    }
}