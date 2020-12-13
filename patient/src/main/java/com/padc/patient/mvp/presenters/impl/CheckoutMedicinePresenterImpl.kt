package com.padc.patient.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import com.padc.patient.mvp.presenters.CheckoutMedicinePresenter
import com.padc.patient.mvp.views.CheckoutMedicineView
import com.padc.shared.data.model.impl.PatientModelImpl
import com.padc.shared.data.vos.AddressVO
import com.padc.shared.data.vos.CheckoutVO
import com.padc.shared.mvp.presenters.AbstractBasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 12/6/2020.
 */
class CheckoutMedicinePresenterImpl: CheckoutMedicinePresenter, AbstractBasePresenter<CheckoutMedicineView>() {
    private var mPatientModel = PatientModelImpl

    override fun onTapAddNewAddress(address: AddressVO) {
        mView?.showAddressForm()
    }

    override fun onTapOrder(data: CheckoutVO) {
        mView?.showCheckoutConfirmDialog(data)
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        // address & special ques list by patient // consulation
    }
}