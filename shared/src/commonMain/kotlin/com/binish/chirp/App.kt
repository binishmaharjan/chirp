package com.binish.chirp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource

import chirp.shared.generated.resources.Res
import chirp.shared.generated.resources.compose_multiplatform
import com.binish.core.designsystem.theme.ChirpTheme
import register.RegisterRoot

@Composable
fun App() {
    ChirpTheme {
        RegisterRoot()
    }
}