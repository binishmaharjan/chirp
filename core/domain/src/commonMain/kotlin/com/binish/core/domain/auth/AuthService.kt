package com.binish.core.domain.auth

import com.binish.core.domain.util.DataError
import com.binish.core.domain.util.EmptyResult

interface AuthService {
    suspend fun register(
        email: String,
        username: String,
        password: String
    ): EmptyResult<DataError.Remote>
}