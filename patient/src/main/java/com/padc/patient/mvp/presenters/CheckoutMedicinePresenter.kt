package com.padc.patient.mvp.presenters

import com.padc.patient.mvp.views.CheckoutMedicineView
import com.padc.shared.data.vos.AddressVO
import com.padc.shared.data.vos.CheckoutVO
import com.padc.shared.mvp.presenters.BasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
interface CheckoutMedicinePresenter: BasePresenter<CheckoutMedicineView> {
    fun onTapAddNewAddress(address: AddressVO)

    fun onTapOrder(data: CheckoutVO)
}