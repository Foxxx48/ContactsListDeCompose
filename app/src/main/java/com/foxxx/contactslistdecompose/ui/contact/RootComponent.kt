package com.foxxx.contactslistdecompose.ui.contact

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.foxxx.contactslistdecompose.presentation.AddContactComponent
import com.foxxx.contactslistdecompose.presentation.ContactListComponent
import com.foxxx.contactslistdecompose.presentation.DefaultRootComponent
import com.foxxx.contactslistdecompose.presentation.EditContactComponent

@Composable
fun RootComponent(
    component: DefaultRootComponent
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Children(stack = component.stack) {
            when (val instance = it.instance) {
                is ContactListComponent -> {
                    Contacts(component = instance)
                }

                is AddContactComponent -> {
                    AddContact(component = instance)
                }

                is EditContactComponent -> {
                    EditContact(component = instance)

                }
            }
        }
    }

}