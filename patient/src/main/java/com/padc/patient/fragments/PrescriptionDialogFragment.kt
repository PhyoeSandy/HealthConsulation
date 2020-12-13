package com.padc.patient.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.padc.patient.R
import com.padc.patient.mvp.presenters.ProfilePresenter
import com.padc.patient.mvp.presenters.impl.ProfilePresenterImpl
import com.padc.patient.mvp.views.ProfileView
import com.padc.shared.fragments.BaseFragment

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/8/2020.
 */

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PrescriptionDialogFragment: BaseFragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mPresenter: ProfilePresenter

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
        return inflater.inflate(R.layout.fragment_prescription_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        /*setUpRecycler()
        mPresenter.onUiReady(this)*/
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<ProfilePresenterImpl, ProfileView>()
    }
}