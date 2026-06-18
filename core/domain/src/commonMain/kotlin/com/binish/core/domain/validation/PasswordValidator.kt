package com.binish.core.domain.validation

data class PasswordValidatorState(
    val hasMinLength: Boolean = false,
    val hasDigit: Boolean = false,
    val hasUppercase: Boolean = false
) {
    val isValidPassword: Boolean get() = hasMinLength && hasDigit && hasUppercase
}

object PasswordValidator {
    private const val MIN_PASSWORD_LENGTH = 9

    fun validate(password: String): PasswordValidatorState {
        return PasswordValidatorState(
            hasMinLength = password.length >= MIN_PASSWORD_LENGTH,
            hasDigit = password.any { it.isDigit() },
            hasUppercase = password.any { it.isUpperCase() }
        )
    }
}