package com.foxxx.contactslistdecompose.domain

import com.foxxx.contactslistdecompose.domain.Contact
import com.foxxx.contactslistdecompose.domain.Repository

class AddContactUseCase(
    private val repository: Repository
) {

    operator fun invoke(
        username: String,
        phone: String
    ) {
        val contact = Contact(
            username = username,
            phone = phone
        )
        repository.saveContact(contact)
    }
}