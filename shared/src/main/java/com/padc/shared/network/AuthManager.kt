package com.padc.shared.network

/**
 * Created by Phyoe Sandy Soe Tun
 * on 11/27/2020.
 */
interface AuthManager {
    fun register(
        name: String, email: String, password: String,
        onSuccess: () -> Unit, onFailure: (String) -> Unit
    )

    fun login(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)

}