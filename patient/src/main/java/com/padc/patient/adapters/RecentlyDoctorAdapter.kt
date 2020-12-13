package com.padc.patient.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.patient.R
import com.padc.patient.views.viewholders.RecentDoctorViewholder
import com.padc.shared.adapters.BaseRecyclerAdapter
import com.padc.shared.data.vos.DoctorVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/12/2020.
 */
class RecentlyDoctorAdapter: BaseRecyclerAdapter<RecentDoctorViewholder,DoctorVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentDoctorViewholder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recent_doctor, parent, false)
        return RecentDoctorViewholder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: RecentDoctorViewholder, position: Int) {
        super.onBindViewHolder(holder, position)
    }
}