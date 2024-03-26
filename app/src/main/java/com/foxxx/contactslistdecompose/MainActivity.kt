package com.foxxx.contactslistdecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import com.foxxx.contactslistdecompose.presentation.DefaultRootComponent
import com.foxxx.contactslistdecompose.ui.contact.RootComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component = DefaultRootComponent(defaultComponentContext())
        setContent {
            RootComponent(component = component)
        }
    }
}
