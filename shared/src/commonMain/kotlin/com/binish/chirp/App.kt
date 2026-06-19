package com.binish.chirp

import androidx.compose.runtime.*

import com.binish.core.designsystem.theme.ChirpTheme
import com.binish.auth.presentation.register.RegisterRoot

@Composable
fun App() {
    ChirpTheme {
        RegisterRoot(
            onRegisterSuccess = { }
        )
    }
}