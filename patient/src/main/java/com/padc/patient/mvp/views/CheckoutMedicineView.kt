package com.padc.patient.mvp.views

import com.padc.shared.data.vos.CheckoutVO
import com.padc.shared.data.vos.MedicineVO
import com.padc.shared.mvp.views.BaseView

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
interface CheckoutMedicineView: BaseView {
    fun showPrescriptionList(list: List<MedicineVO>)

    fun showCheckoutConfirmDialog(data: CheckoutVO)

    fun showAddressForm()
}