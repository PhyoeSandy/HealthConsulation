package com.padc.patient.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.padc.patient.R
import com.padc.patient.mvp.presenters.AppointmentsPresenter
import com.padc.patient.mvp.presenters.impl.AppointmentsPresenterImpl
import com.padc.patient.mvp.views.AppointmentsView
import com.padc.shared.data.vos.ConsulationVO
import com.padc.shared.data.vos.MedicineVO
import com.padc.shared.data.vos.TreatmentRecordVO
import com.padc.shared.fragments.BaseFragment

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/10/2020.
 */
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AppointmentsFragment: BaseFragment(), AppointmentsView {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mPresenter: AppointmentsPresenter

    companion object {
        @JvmStatic
        fun newInstance() = AppointmentsFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_appointments, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        /*setUpRecycler()
        mPresenter.onUiReady(this)*/
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<AppointmentsPresenterImpl, AppointmentsView>()
    }

    override fun showConsulationHistory(list: List<ConsulationVO>) {
        TODO("Not yet implemented")
    }

    override fun showPrescriptionDialog(list: List<MedicineVO>) {
        TODO("Not yet implemented")
    }

    override fun showMedicalRecord(record: TreatmentRecordVO) {
        TODO("Not yet implemented")
    }

    override fun hidePrescriptionDialog() {
        TODO("Not yet implemented")
    }
}