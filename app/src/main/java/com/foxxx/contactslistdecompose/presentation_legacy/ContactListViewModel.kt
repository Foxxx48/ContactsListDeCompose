package com.foxxx.contactslistdecompose.presentation_legacy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.foxxx.contactslistdecompose.data.RepositoryImpl
import com.foxxx.contactslistdecompose.domain.GetContactsUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class ContactListViewModel : ViewModel() {

    private val repository = RepositoryImpl

    private val getContactsUseCase = GetContactsUseCase(repository)

    val contacts = getContactsUseCase().stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = listOf()
    )
}