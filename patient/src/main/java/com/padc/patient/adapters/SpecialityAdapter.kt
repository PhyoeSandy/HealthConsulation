package com.padc.patient.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.patient.R
import com.padc.patient.views.viewholders.SpecialityViewholder
import com.padc.shared.adapters.BaseRecyclerAdapter
import com.padc.shared.data.vos.SpecialityVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/12/2020.
 */
class SpecialityAdapter: BaseRecyclerAdapter<SpecialityViewholder,SpecialityVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialityViewholder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_speciality, parent, false)
        return SpecialityViewholder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: SpecialityViewholder, position: Int) {
        super.onBindViewHolder(holder, position)
    }
}