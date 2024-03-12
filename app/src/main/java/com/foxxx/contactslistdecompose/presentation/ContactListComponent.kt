package com.foxxx.contactslistdecompose.presentation

import com.foxxx.contactslistdecompose.domain.Contact
import kotlinx.coroutines.flow.StateFlow

interface ContactListComponent {

    val model: StateFlow<Model>

    fun onContactClicked(contact: Contact)

    fun onAddContactClicked()

    data class Model(
        val contactList: List<Contact>
    )
}