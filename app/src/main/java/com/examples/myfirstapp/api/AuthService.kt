package com.examples.myfirstapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

data class LoginRequest(val email: String, val password: String)
data class LoginResponse(val token: String)

interface AuthService {
    @POST("api/users/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    companion object {
        fun create(): AuthService {
            return Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/") // Para acessar o backend local no emulador
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AuthService::class.java)
        }
    }
}
