package com.padc.patient.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.patient.R
import com.padc.patient.views.viewholders.GeneralQuesViewholder
import com.padc.shared.adapters.BaseRecyclerAdapter
import com.padc.shared.data.vos.GeneralQuesVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/12/2020.
 */
class GeneralQuesAdapter: BaseRecyclerAdapter<GeneralQuesViewholder, GeneralQuesVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneralQuesViewholder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_general_ques, parent, false)
        return GeneralQuesViewholder(view)
    }
}