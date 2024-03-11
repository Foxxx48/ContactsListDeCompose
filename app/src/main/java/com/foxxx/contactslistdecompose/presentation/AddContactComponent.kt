package com.foxxx.contactslistdecompose.presentation

import kotlinx.coroutines.flow.StateFlow

interface AddContactComponent {

    val model: StateFlow<Model>

    fun onUsernameChanged(username: String)

    fun onPhoneChanged(phone: String)

    fun onSaveContactClicked()

    data class Model(
        val username: String,
        val phone: String
    )
}