package com.padc.shared.network.impl

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.storage.FirebaseStorage
import com.padc.shared.extensions.NO_INTERNET
import com.padc.shared.network.AuthManager

/**
 * Created by Phyoe Sandy Soe Tun
 * on 11/27/2020.
 */
object AuthManagerImpl : AuthManager {
    private val mFirebaseAuth = FirebaseAuth.getInstance()
    private val storage = FirebaseStorage.getInstance()
    private val storageReference = storage.reference

    override fun register(
        name: String,
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful && it.isComplete) {
                    mFirebaseAuth.currentUser?.updateProfile(
                        UserProfileChangeRequest.Builder()
                            .setDisplayName(name).build()
                    )
                    onSuccess()
                } else onFailure(it.exception?.message ?: NO_INTERNET)
            }
    }

    override fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isComplete && it.isSuccessful) onSuccess()
                else onFailure(it.exception?.message ?: NO_INTERNET)
            }
    }
}