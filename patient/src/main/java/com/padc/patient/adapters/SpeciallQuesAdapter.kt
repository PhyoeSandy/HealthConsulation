package com.padc.patient.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.patient.R
import com.padc.patient.views.viewholders.SpecialQuesViewholder
import com.padc.shared.adapters.BaseRecyclerAdapter
import com.padc.shared.data.vos.SpecialQuesVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/12/2020.
 */
class SpeciallQuesAdapter : BaseRecyclerAdapter<SpecialQuesViewholder, SpecialQuesVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialQuesViewholder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_special_ques, parent, false)
        return SpecialQuesViewholder(view)
    }
}