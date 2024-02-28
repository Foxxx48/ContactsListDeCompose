package com.foxxx.contactslistdecompose.domain

import kotlinx.coroutines.flow.Flow

class GetContactsUseCase(
    private val repository: Repository
) {

    operator fun invoke(): Flow<List<Contact>> = repository.contacts
}