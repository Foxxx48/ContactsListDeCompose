package com.foxxx.contactslistdecompose.presentation_legacy

import androidx.lifecycle.ViewModel
import com.foxxx.contactslistdecompose.data.RepositoryImpl
import com.foxxx.contactslistdecompose.domain.AddContactUseCase
import com.foxxx.contactslistdecompose.domain.Contact
import com.foxxx.contactslistdecompose.domain.EditContactUseCase

class ContactDetailViewModel  : ViewModel() {

    private val repository = RepositoryImpl

    private val addContactUseCase = AddContactUseCase(repository)
    private val editContactUseCase = EditContactUseCase(repository)

    fun addContact(username: String, phone: String) {
        addContactUseCase(username, phone)
    }

    fun editContact(contact: Contact) {
        editContactUseCase(contact)
    }
}