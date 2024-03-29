package com.foxxx.contactslistdecompose.presentation

import com.arkivanov.decompose.ComponentContext
import com.foxxx.contactslistdecompose.core.componentScope
import com.foxxx.contactslistdecompose.data.RepositoryImpl
import com.foxxx.contactslistdecompose.domain.Contact
import com.foxxx.contactslistdecompose.domain.GetContactsUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


class DefaultContactListComponent(
    componentContext: ComponentContext,
    val onEditingContactRequested: (Contact) -> Unit,
    val onAddContactRequested: () -> Unit,
) : ContactListComponent, ComponentContext by componentContext {

    private val repository = RepositoryImpl
    private val getContactsUseCase = GetContactsUseCase(repository)
    private val coroutineScope = componentScope()

    override val model: StateFlow<ContactListComponent.Model> = getContactsUseCase()
        .map { ContactListComponent.Model(it) }
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.Lazily,
            initialValue = ContactListComponent.Model(listOf())
        )

    override fun onContactClicked(contact: Contact) {
        onEditingContactRequested(contact)
    }

    override fun onAddContactClicked() {
        onAddContactRequested()
    }
}