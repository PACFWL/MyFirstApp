package com.examples.myfirstapp.repository

import com.examples.myfirstapp.api.AuthService
import com.examples.myfirstapp.api.LoginRequest

class AuthRepository(private val authService: AuthService = AuthService.create()) {
    suspend fun login(email: String, password: String) = authService.login(LoginRequest(email, password))
}
