package com.examples.myfirstapp.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.examples.myfirstapp.repository.AuthRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val authRepository: AuthRepository = AuthRepository()) : ViewModel() {
    var email: String = ""
    var password: String = ""
    var isLoading: Boolean = false
    var loginMessage: String? = null

    fun login(onResult: (Boolean, String) -> Unit) {
        if (email.isBlank() || password.isBlank()) {
            onResult(false, "Preencha todos os campos!")
            return
        }

        isLoading = true
        viewModelScope.launch {
            try {
                val response = authRepository.login(email, password)
                isLoading = false
                onResult(true, "Login bem-sucedido!")
            } catch (e: Exception) {
                isLoading = false
                Log.e("LoginError", "Erro ao fazer login", e)
                onResult(false, "Erro: ${e.message}")
            }
        }
    }
}
