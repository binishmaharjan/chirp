package com.binish.chirp

import androidx.compose.runtime.*

import com.binish.core.designsystem.theme.ChirpTheme
import com.binish.auth.presentation.register.RegisterRoot
import com.binish.chirp.navigation.NavigationRoot

@Composable
fun App() {
    ChirpTheme {
        NavigationRoot()
    }
}