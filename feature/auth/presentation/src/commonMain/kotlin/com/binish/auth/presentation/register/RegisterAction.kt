package com.binish.auth.presentation.register

sealed interface RegisterAction {
    data object OnLoginClick: RegisterAction
    data object OnInputTextFocusGain: RegisterAction
    data object OnRegisterClick: RegisterAction
    data object OnTogglePasswordVisibilityClick: RegisterAction
}

sealed interface RegisterEvent {
    data class Success(val email: String): RegisterEvent
}