package com.padc.patient.fragments

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.padc.patient.R
import com.padc.patient.activities.PatientInfoActivity
import com.padc.patient.adapters.RecentlyDoctorAdapter
import com.padc.patient.adapters.SpecialityAdapter
import com.padc.patient.mvp.presenters.HomePresenter
import com.padc.patient.mvp.presenters.impl.HomePresenterImpl
import com.padc.patient.mvp.views.HomeView
import com.padc.shared.data.vos.DoctorVO
import com.padc.shared.data.vos.SpecialityVO
import com.padc.shared.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_consulation_dialog.*
import kotlinx.android.synthetic.main.fragment_consulation_dialog.view.*
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/10/2020.
 */
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : BaseFragment(), HomeView {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mPresenter: HomePresenter
    private lateinit var mSpecialityAdapter: SpecialityAdapter
    private lateinit var mRecentlyDoctorAdapter: RecentlyDoctorAdapter

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
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
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpRecycler()
        mPresenter.onUiReady(this)
    }

    private fun setUpRecycler() {
        mSpecialityAdapter = SpecialityAdapter()
        rc_speciality.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = mSpecialityAdapter
        }

        mRecentlyDoctorAdapter = RecentlyDoctorAdapter()
        rc_recent_doctor.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = mRecentlyDoctorAdapter
        }

    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<HomePresenterImpl, HomeView>()
    }

    override fun showSpecialityList(specialityList: List<SpecialityVO>) {
        mSpecialityAdapter.setNewData(specialityList.toMutableList())
    }

    override fun showRecentlyDoctor(doctorList: List<DoctorVO>) {
        if (doctorList.isNotEmpty()) {
            ly_recentdoctor.visibility = View.VISIBLE
        } else {
            ly_recentdoctor.visibility = View.GONE
        }
        mRecentlyDoctorAdapter.setNewData(doctorList.toMutableList())
    }

    override fun showConsulationDialog(specialityName: String) {


    }

    override fun navigateToPatientInfoScreen(patientId: String) {
        startActivity(
            activity?.applicationContext?.let {
                PatientInfoActivity.newIntent(it)
            }
        )
    }


}